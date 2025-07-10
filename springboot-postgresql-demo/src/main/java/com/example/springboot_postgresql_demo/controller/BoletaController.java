package com.example.springboot_postgresql_demo.controller;

import com.example.springboot_postgresql_demo.entity.Boleta;
import com.example.springboot_postgresql_demo.service.BoletaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boletas")
public class BoletaController {
    private final BoletaService servicio;

    public BoletaController(BoletaService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Boleta> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boleta> buscar(@PathVariable int id) {
        return servicio.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Boleta crear(@RequestBody Boleta boleta) {
        return servicio.guardar(boleta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boleta> actualizar(@PathVariable int id, @RequestBody Boleta boleta) {
        return servicio.buscarPorId(id).map(b -> {
            boleta.setIdBoleta(id);
            servicio.actualizar(id, boleta);
            return ResponseEntity.ok(boleta);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        servicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
