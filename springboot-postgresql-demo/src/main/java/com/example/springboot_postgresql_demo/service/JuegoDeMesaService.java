package com.example.springboot_postgresql_demo.service;

import com.example.springboot_postgresql_demo.entity.JuegoDeMesa;
import com.example.springboot_postgresql_demo.repository.JuegoDeMesaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JuegoDeMesaService {
    private final JuegoDeMesaRepository repo;

    public JuegoDeMesaService(JuegoDeMesaRepository repo) {
        this.repo = repo;
    }

    public List<JuegoDeMesa> listar() {
        return repo.listar();
    }

    public Optional<JuegoDeMesa> buscarPorId(int id) {
        return repo.buscarPorId(id);
    }

    public JuegoDeMesa guardar(JuegoDeMesa juego) {
        return repo.guardar(juego);
    }

    public void actualizar(int id, JuegoDeMesa juego) {
        repo.actualizar(id, juego);
    }

    public void eliminar(int id) {
        repo.eliminar(id);
    }
}
