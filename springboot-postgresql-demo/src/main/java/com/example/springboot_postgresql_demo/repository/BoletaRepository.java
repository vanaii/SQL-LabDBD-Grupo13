package com.example.springboot_postgresql_demo.repository;

import com.example.springboot_postgresql_demo.entity.Boleta;
import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.Optional;

@Repository
public class BoletaRepository {
    private final Sql2o sql2o;

    public BoletaRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public List<Boleta> listar() {
        String sql = "SELECT * FROM boleta";
        try (var con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Boleta.class);
        }
    }

    public Optional<Boleta> buscarPorId(int id) {
        String sql = "SELECT * FROM boleta WHERE id_boleta = :id";
        try (var con = sql2o.open()) {
            Boleta boleta = con.createQuery(sql)
                .addParameter("id", id)
                .executeAndFetchFirst(Boleta.class);
            return Optional.ofNullable(boleta);
        }
    }

    public Boleta guardar(Boleta boleta) {
        String sql = "INSERT INTO boleta (id_usuario, medio_pago, fecha, total) " +
                     "VALUES (:idUsuario, :medioPago, :fecha, :total)";
        try (var con = sql2o.open()) {
            Integer id = con.createQuery(sql, true)
                .bind(boleta)
                .executeUpdate()
                .getKey(Integer.class);
            boleta.setIdBoleta(id);
            return boleta;
        }
    }

    public void actualizar(int id, Boleta boleta) {
        String sql = "UPDATE boleta SET id_usuario = :idUsuario, medio_pago = :medioPago, fecha = :fecha, total = :total " +
                     "WHERE id_boleta = :id";
        try (var con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("id", id)
                .bind(boleta)
                .executeUpdate();
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM boleta WHERE id_boleta = :id";
        try (var con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("id", id)
                .executeUpdate();
        }
    }
}
