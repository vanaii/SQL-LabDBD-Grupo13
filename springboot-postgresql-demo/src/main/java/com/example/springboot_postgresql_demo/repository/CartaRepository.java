package com.example.springboot_postgresql_demo.repository;

import com.example.springboot_postgresql_demo.entity.Carta;
import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.Optional;

@Repository
public class CartaRepository {
    private final Sql2o sql2o;

    public CartaRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public List<Carta> listar() {
        String sql = "SELECT * FROM carta";
        try (var con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Carta.class);
        }
    }

    public Optional<Carta> buscarPorId(int id) {
        String sql = "SELECT * FROM carta WHERE id_carta = :id";
        try (var con = sql2o.open()) {
            Carta carta = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Carta.class);
            return Optional.ofNullable(carta);
        }
    }

    public Carta guardar(Carta carta) {
        String sql = "INSERT INTO carta (id_producto, rareza, estado, anio) " +
                     "VALUES (:idProducto, :rareza, :estado, :anio)";
        try (var con = sql2o.open()) {
            Integer id = con.createQuery(sql, true)
                    .bind(carta)
                    .executeUpdate()
                    .getKey(Integer.class);
            carta.setIdCarta(id);
            return carta;
        }
    }

    public void actualizar(int id, Carta carta) {
        String sql = "UPDATE carta SET id_producto = :idProducto, rareza = :rareza, estado = :estado, anio = :anio " +
                     "WHERE id_carta = :id";
        try (var con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("id", id)
                .bind(carta)
                .executeUpdate();
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM carta WHERE id_carta = :id";
        try (var con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("id", id)
                .executeUpdate();
        }
    }
}
