package com.example.springboot_postgresql_demo.controller;

import com.example.springboot_postgresql_demo.entity.CarroDeCompras;
import com.example.springboot_postgresql_demo.service.CarroDeComprasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroDeComprasController {
    private final CarroDeComprasService servicio;

    public CarroDeComprasController(CarroDeComprasService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<CarroDeCompras> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroDeCompras> buscar(@PathVariable int id) {
        return servicio.buscarPorId(id)
                       .map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CarroDeCompras crear(@RequestBody CarroDeCompras carro) {
        return servicio.guardar(carro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarroDeCompras> actualizar(@PathVariable int id, @RequestBody CarroDeCompras carro) {
        return servicio.buscarPorId(id).map(c -> {
            carro.setIdCarro(id);
            servicio.actualizar(id, carro);
            return ResponseEntity.ok(carro);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        servicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
