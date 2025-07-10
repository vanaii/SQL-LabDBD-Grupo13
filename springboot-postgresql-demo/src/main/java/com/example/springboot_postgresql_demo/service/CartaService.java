package com.example.springboot_postgresql_demo.service;

import com.example.springboot_postgresql_demo.entity.Carta;
import com.example.springboot_postgresql_demo.repository.CartaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartaService {
    private final CartaRepository repo;

    public CartaService(CartaRepository repo) {
        this.repo = repo;
    }

    public List<Carta> listar() {
        return repo.listar();
    }

    public Optional<Carta> buscarPorId(int id) {
        return repo.buscarPorId(id);
    }

    public Carta guardar(Carta carta) {
        return repo.guardar(carta);
    }

    public void actualizar(int id, Carta carta) {
        repo.actualizar(id, carta);
    }

    public void eliminar(int id) {
        repo.eliminar(id);
    }
}
