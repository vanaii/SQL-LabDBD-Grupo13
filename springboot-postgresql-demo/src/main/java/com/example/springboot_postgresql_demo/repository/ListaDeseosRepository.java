package com.example.springboot_postgresql_demo.repository;

import com.example.springboot_postgresql_demo.entity.ListaDeseos;
import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.Optional;

@Repository
public class ListaDeseosRepository {
    private final Sql2o sql2o;

    public ListaDeseosRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public List<ListaDeseos> listar() {
        String sql = "SELECT * FROM lista_deseos";
        try (var con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(ListaDeseos.class);
        }
    }

    public Optional<ListaDeseos> buscarPorId(int id) {
        String sql = "SELECT * FROM lista_deseos WHERE id_deseo = :id";
        try (var con = sql2o.open()) {
            ListaDeseos deseo = con.createQuery(sql)
                .addParameter("id", id)
                .executeAndFetchFirst(ListaDeseos.class);
            return Optional.ofNullable(deseo);
        }
    }

    public ListaDeseos guardar(ListaDeseos deseo) {
        String sql = "INSERT INTO lista_deseos (id_usuario, id_producto) VALUES (:idUsuario, :idProducto)";
        try (var con = sql2o.open()) {
            Integer id = con.createQuery(sql, true)
                .bind(deseo)
                .executeUpdate()
                .getKey(Integer.class);
            deseo.setIdDeseo(id);
            return deseo;
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM lista_deseos WHERE id_deseo = :id";
        try (var con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("id", id)
                .executeUpdate();
        }
    }
}
