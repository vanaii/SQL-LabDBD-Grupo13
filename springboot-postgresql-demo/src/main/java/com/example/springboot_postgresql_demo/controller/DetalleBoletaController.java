package com.example.springboot_postgresql_demo.controller;

import com.example.springboot_postgresql_demo.entity.DetalleBoleta;
import com.example.springboot_postgresql_demo.service.DetalleBoletaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle-boletas")
public class DetalleBoletaController {
    private final DetalleBoletaService servicio;

    public DetalleBoletaController(DetalleBoletaService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<DetalleBoleta> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleBoleta> buscar(@PathVariable int id) {
        return servicio.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DetalleBoleta crear(@RequestBody DetalleBoleta detalle) {
        return servicio.guardar(detalle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleBoleta> actualizar(@PathVariable int id, @RequestBody DetalleBoleta detalle) {
        return servicio.buscarPorId(id).map(d -> {
            detalle.setIdDetalle(id);
            servicio.actualizar(id, detalle);
            return ResponseEntity.ok(detalle);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        servicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
