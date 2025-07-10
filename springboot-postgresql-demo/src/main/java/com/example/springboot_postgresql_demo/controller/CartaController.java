package com.example.springboot_postgresql_demo.controller;

import com.example.springboot_postgresql_demo.entity.Carta;
import com.example.springboot_postgresql_demo.service.CartaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartas")
public class CartaController {

    private final CartaService servicio;

    public CartaController(CartaService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Carta> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carta> buscar(@PathVariable int id) {
        return servicio.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Carta crear(@RequestBody Carta carta) {
        return servicio.guardar(carta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carta> actualizar(@PathVariable int id, @RequestBody Carta carta) {
        return servicio.buscarPorId(id).map(c -> {
            carta.setIdCarta(id);
            servicio.actualizar(id, carta);
            return ResponseEntity.ok(carta);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        servicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
