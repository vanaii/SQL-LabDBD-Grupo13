package com.example.springboot_postgresql_demo.service;

import com.example.springboot_postgresql_demo.entity.CarroDeCompras;
import com.example.springboot_postgresql_demo.repository.CarroDeComprasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroDeComprasService {
    private final CarroDeComprasRepository repo;

    public CarroDeComprasService(CarroDeComprasRepository repo) {
        this.repo = repo;
    }

    public List<CarroDeCompras> listar() {
        return repo.listar();
    }

    public Optional<CarroDeCompras> buscarPorId(int id) {
        return repo.buscarPorId(id);
    }

    public CarroDeCompras guardar(CarroDeCompras carro) {
        return repo.guardar(carro);
    }

    public void actualizar(int id, CarroDeCompras carro) {
        repo.actualizar(id, carro);
    }

    public void eliminar(int id) {
        repo.eliminar(id);
    }
}
