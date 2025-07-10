package com.example.springboot_postgresql_demo.controller;

import com.example.springboot_postgresql_demo.entity.Usuario;
import com.example.springboot_postgresql_demo.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository repositorio;

    public UsuarioController(UsuarioRepository repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping
    public List<Usuario> listar() {
        return repositorio.listar();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> buscar(@PathVariable Integer id) {
        return repositorio.buscarPorId(id);
    }

    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {
        return repositorio.guardar(usuario);
    }

    @PutMapping("/{id}")
    public void actualizar(@PathVariable Integer id, @RequestBody Usuario usuario) {
        repositorio.actualizar(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        repositorio.eliminar(id);
    }

    @PostMapping("/login")
    public Optional<Usuario> login(@RequestBody Usuario intento) {
        return repositorio.buscarPorCorreo(intento.getCorreo())
                .filter(u -> u.getPassword().equals(intento.getPassword()));
    }
}
