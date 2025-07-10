package com.example.springboot_postgresql_demo.controller;

import com.example.springboot_postgresql_demo.entity.JuegoDeMesa;
import com.example.springboot_postgresql_demo.service.JuegoDeMesaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/juegos")
public class JuegoDeMesaController {

    private final JuegoDeMesaService servicio;

    public JuegoDeMesaController(JuegoDeMesaService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<JuegoDeMesa> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JuegoDeMesa> buscar(@PathVariable int id) {
        return servicio.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public JuegoDeMesa crear(@RequestBody JuegoDeMesa juego) {
        return servicio.guardar(juego);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JuegoDeMesa> actualizar(@PathVariable int id, @RequestBody JuegoDeMesa juego) {
        return servicio.buscarPorId(id).map(j -> {
            juego.setIdJuego(id);
            servicio.actualizar(id, juego);
            return ResponseEntity.ok(juego);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        servicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
