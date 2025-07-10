package com.example.springboot_postgresql_demo.service;

import com.example.springboot_postgresql_demo.entity.DetalleBoleta;
import com.example.springboot_postgresql_demo.repository.DetalleBoletaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleBoletaService {
    private final DetalleBoletaRepository repo;

    public DetalleBoletaService(DetalleBoletaRepository repo) {
        this.repo = repo;
    }

    public List<DetalleBoleta> listar() {
        return repo.listar();
    }

    public Optional<DetalleBoleta> buscarPorId(int id) {
        return repo.buscarPorId(id);
    }

    public DetalleBoleta guardar(DetalleBoleta detalle) {
        return repo.guardar(detalle);
    }

    public void actualizar(int id, DetalleBoleta detalle) {
        repo.actualizar(id, detalle);
    }

    public void eliminar(int id) {
        repo.eliminar(id);
    }
}
