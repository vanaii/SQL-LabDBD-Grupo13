package com.example.springboot_postgresql_demo.controller;

import com.example.springboot_postgresql_demo.entity.Valoracion;
import com.example.springboot_postgresql_demo.service.ValoracionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/valoraciones")
public class ValoracionController {
    private final ValoracionService servicio;

    public ValoracionController(ValoracionService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Valoracion> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Valoracion> buscarPorId(@PathVariable int id) {
        return servicio.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Valoracion> crear(@RequestBody Valoracion valoracion) {
        var existente = servicio.buscarPorUsuarioYProducto(valoracion.getIdUsuario(), valoracion.getIdProducto());
        if (existente.isPresent()) {
            return ResponseEntity.badRequest().build(); // ya existe una valoración
        }
        return ResponseEntity.ok(servicio.guardar(valoracion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Valoracion> actualizar(@PathVariable int id, @RequestBody Valoracion valoracion) {
        return servicio.buscarPorId(id).map(v -> {
            valoracion.setIdValoracion(id);
            servicio.actualizar(id, valoracion);
            return ResponseEntity.ok(valoracion);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        servicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
