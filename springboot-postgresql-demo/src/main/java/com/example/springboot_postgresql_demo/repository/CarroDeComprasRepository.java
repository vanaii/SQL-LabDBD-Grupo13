package com.example.springboot_postgresql_demo.repository;

import com.example.springboot_postgresql_demo.entity.CarroDeCompras;
import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.Optional;

@Repository
public class CarroDeComprasRepository {
    private final Sql2o sql2o;

    public CarroDeComprasRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public List<CarroDeCompras> listar() {
        String sql = "SELECT * FROM carro_de_compras";
        try (var con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(CarroDeCompras.class);
        }
    }

    public Optional<CarroDeCompras> buscarPorId(int id) {
        String sql = "SELECT * FROM carro_de_compras WHERE id_carro = :id";
        try (var con = sql2o.open()) {
            return Optional.ofNullable(
                con.createQuery(sql)
                   .addParameter("id", id)
                   .executeAndFetchFirst(CarroDeCompras.class)
            );
        }
    }

    public CarroDeCompras guardar(CarroDeCompras carro) {
        String sql = "INSERT INTO carro_de_compras (id_usuario, activo) VALUES (:idUsuario, :activo)";
        try (var con = sql2o.open()) {
            Integer id = con.createQuery(sql, true)
                            .bind(carro)
                            .executeUpdate()
                            .getKey(Integer.class);
            carro.setIdCarro(id);
            return carro;
        }
    }

    public void actualizar(int id, CarroDeCompras carro) {
        String sql = "UPDATE carro_de_compras SET id_usuario = :idUsuario, activo = :activo WHERE id_carro = :id";
        try (var con = sql2o.open()) {
            con.createQuery(sql)
               .addParameter("id", id)
               .bind(carro)
               .executeUpdate();
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM carro_de_compras WHERE id_carro = :id";
        try (var con = sql2o.open()) {
            con.createQuery(sql)
               .addParameter("id", id)
               .executeUpdate();
        }
    }
}
