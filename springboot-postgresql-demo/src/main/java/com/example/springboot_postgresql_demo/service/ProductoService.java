package com.example.springboot_postgresql_demo.service;

import com.example.springboot_postgresql_demo.entity.Producto;
import com.example.springboot_postgresql_demo.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository repo;

    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    public List<Producto> listar() {
        return repo.listar();
    }

    public Optional<Producto> buscarPorId(Integer id) {
        return repo.buscarPorId(id);
    }

    public Producto guardar(Producto p) {
        return repo.guardar(p);
    }

    public void actualizar(Integer id, Producto p) {
        repo.actualizar(id, p);
    }

    public void eliminar(Integer id) {
        repo.eliminar(id);
    }

    public List<Producto> filtrarPorUbicacion(String ubicacion) {
        return repo.filtrarPorUbicacion(ubicacion);
    }
}