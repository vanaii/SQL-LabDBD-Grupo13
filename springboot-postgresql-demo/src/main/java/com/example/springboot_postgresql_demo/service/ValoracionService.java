package com.example.springboot_postgresql_demo.service;

import com.example.springboot_postgresql_demo.entity.Valoracion;
import com.example.springboot_postgresql_demo.repository.ValoracionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ValoracionService {
    private final ValoracionRepository repo;

    public ValoracionService(ValoracionRepository repo) {
        this.repo = repo;
    }

    public List<Valoracion> listar() {
        return repo.listar();
    }

    public Optional<Valoracion> buscarPorId(int id) {
        return repo.buscarPorId(id);
    }

    public Optional<Valoracion> buscarPorUsuarioYProducto(int idUsuario, int idProducto) {
        return repo.buscarPorUsuarioYProducto(idUsuario, idProducto);
    }

    public Valoracion guardar(Valoracion valoracion) {
        return repo.guardar(valoracion);
    }

    public void actualizar(int id, Valoracion valoracion) {
        repo.actualizar(id, valoracion);
    }

    public void eliminar(int id) {
        repo.eliminar(id);
    }
}
