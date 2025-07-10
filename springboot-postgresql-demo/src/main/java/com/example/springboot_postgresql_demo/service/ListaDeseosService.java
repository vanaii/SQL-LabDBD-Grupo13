package com.example.springboot_postgresql_demo.service;

import com.example.springboot_postgresql_demo.entity.ListaDeseos;
import com.example.springboot_postgresql_demo.repository.ListaDeseosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListaDeseosService {
    private final ListaDeseosRepository repo;

    public ListaDeseosService(ListaDeseosRepository repo) {
        this.repo = repo;
    }

    public List<ListaDeseos> listar() {
        return repo.listar();
    }

    public Optional<ListaDeseos> buscarPorId(int id) {
        return repo.buscarPorId(id);
    }

    public ListaDeseos guardar(ListaDeseos deseo) {
        return repo.guardar(deseo);
    }

    public void eliminar(int id) {
        repo.eliminar(id);
    }
}
