package com.example.springboot_postgresql_demo.controller;

import com.example.springboot_postgresql_demo.entity.ListaDeseos;
import com.example.springboot_postgresql_demo.service.ListaDeseosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lista-deseos")
public class ListaDeseosController {
    private final ListaDeseosService servicio;

    public ListaDeseosController(ListaDeseosService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<ListaDeseos> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListaDeseos> buscar(@PathVariable int id) {
        return servicio.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ListaDeseos crear(@RequestBody ListaDeseos deseo) {
        return servicio.guardar(deseo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        servicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
