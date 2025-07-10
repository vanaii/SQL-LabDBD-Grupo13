package com.example.springboot_postgresql_demo.repository;

import com.example.springboot_postgresql_demo.entity.Valoracion;
import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.Optional;

@Repository
public class ValoracionRepository {
    private final Sql2o sql2o;

    public ValoracionRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public List<Valoracion> listar() {
        String sql = "SELECT * FROM valoracion";
        try (var con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Valoracion.class);
        }
    }

    public Optional<Valoracion> buscarPorId(int id) {
        String sql = "SELECT * FROM valoracion WHERE id_valoracion = :id";
        try (var con = sql2o.open()) {
            Valoracion v = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Valoracion.class);
            return Optional.ofNullable(v);
        }
    }

    public Optional<Valoracion> buscarPorUsuarioYProducto(int idUsuario, int idProducto) {
        String sql = "SELECT * FROM valoracion WHERE id_usuario = :idUsuario AND id_producto = :idProducto";
        try (var con = sql2o.open()) {
            Valoracion v = con.createQuery(sql)
                    .addParameter("idUsuario", idUsuario)
                    .addParameter("idProducto", idProducto)
                    .executeAndFetchFirst(Valoracion.class);
            return Optional.ofNullable(v);
        }
    }

    public Valoracion guardar(Valoracion valoracion) {
        String sql = "INSERT INTO valoracion (id_usuario, id_producto, puntaje, comentario) " +
                     "VALUES (:idUsuario, :idProducto, :puntaje, :comentario)";
        try (var con = sql2o.open()) {
            Integer id = con.createQuery(sql, true)
                    .bind(valoracion)
                    .executeUpdate()
                    .getKey(Integer.class);
            valoracion.setIdValoracion(id);
            return valoracion;
        }
    }

    public void actualizar(int id, Valoracion valoracion) {
        String sql = "UPDATE valoracion SET puntaje = :puntaje, comentario = :comentario WHERE id_valoracion = :id";
        try (var con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .bind(valoracion)
                    .executeUpdate();
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM valoracion WHERE id_valoracion = :id";
        try (var con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }
}
