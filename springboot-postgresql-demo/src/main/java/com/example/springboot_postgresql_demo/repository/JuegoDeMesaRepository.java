package com.example.springboot_postgresql_demo.repository;

import com.example.springboot_postgresql_demo.entity.JuegoDeMesa;
import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.Optional;

@Repository
public class JuegoDeMesaRepository {
    private final Sql2o sql2o;

    public JuegoDeMesaRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public List<JuegoDeMesa> listar() {
        String sql = "SELECT * FROM juego_de_mesa";
        try (var con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(JuegoDeMesa.class);
        }
    }

    public Optional<JuegoDeMesa> buscarPorId(int id) {
        String sql = "SELECT * FROM juego_de_mesa WHERE id_juego = :id";
        try (var con = sql2o.open()) {
            JuegoDeMesa juego = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(JuegoDeMesa.class);
            return Optional.ofNullable(juego);
        }
    }

    public JuegoDeMesa guardar(JuegoDeMesa juego) {
        String sql = "INSERT INTO juego_de_mesa (id_producto, tipo) VALUES (:idProducto, :tipo)";
        try (var con = sql2o.open()) {
            Integer id = con.createQuery(sql, true)
                    .bind(juego)
                    .executeUpdate()
                    .getKey(Integer.class);
            juego.setIdJuego(id);
            return juego;
        }
    }

    public void actualizar(int id, JuegoDeMesa juego) {
        String sql = "UPDATE juego_de_mesa SET id_producto = :idProducto, tipo = :tipo WHERE id_juego = :id";
        try (var con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("id", id)
                .bind(juego)
                .executeUpdate();
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM juego_de_mesa WHERE id_juego = :id";
        try (var con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("id", id)
                .executeUpdate();
        }
    }
}
