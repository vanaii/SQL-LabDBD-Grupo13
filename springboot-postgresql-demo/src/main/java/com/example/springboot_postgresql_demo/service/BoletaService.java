package com.example.springboot_postgresql_demo.service;

import com.example.springboot_postgresql_demo.entity.Boleta;
import com.example.springboot_postgresql_demo.repository.BoletaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoletaService {
    private final BoletaRepository repo;

    public BoletaService(BoletaRepository repo) {
        this.repo = repo;
    }

    public List<Boleta> listar() {
        return repo.listar();
    }

    public Optional<Boleta> buscarPorId(int id) {
        return repo.buscarPorId(id);
    }

    public Boleta guardar(Boleta boleta) {
        return repo.guardar(boleta);
    }

    public void actualizar(int id, Boleta boleta) {
        repo.actualizar(id, boleta);
    }

    public void eliminar(int id) {
        repo.eliminar(id);
    }
}
