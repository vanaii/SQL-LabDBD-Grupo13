package com.example.springboot_postgresql_demo.repository;

import com.example.springboot_postgresql_demo.entity.DetalleBoleta;
import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.Optional;

@Repository
public class DetalleBoletaRepository {
    private final Sql2o sql2o;

    public DetalleBoletaRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public List<DetalleBoleta> listar() {
        String sql = "SELECT * FROM detalle_boleta";
        try (var con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(DetalleBoleta.class);
        }
    }

    public Optional<DetalleBoleta> buscarPorId(int id) {
        String sql = "SELECT * FROM detalle_boleta WHERE id_detalle = :id";
        try (var con = sql2o.open()) {
            DetalleBoleta detalle = con.createQuery(sql)
                .addParameter("id", id)
                .executeAndFetchFirst(DetalleBoleta.class);
            return Optional.ofNullable(detalle);
        }
    }

    public DetalleBoleta guardar(DetalleBoleta detalle) {
        String sql = "INSERT INTO detalle_boleta (id_boleta, id_producto, cantidad, subtotal) " +
                     "VALUES (:idBoleta, :idProducto, :cantidad, :subtotal)";
        try (var con = sql2o.open()) {
            Integer id = con.createQuery(sql, true)
                            .bind(detalle)
                            .executeUpdate()
                            .getKey(Integer.class);
            detalle.setIdDetalle(id);
            return detalle;
        }
    }

    public void actualizar(int id, DetalleBoleta detalle) {
        String sql = "UPDATE detalle_boleta SET id_boleta = :idBoleta, id_producto = :idProducto, " +
                     "cantidad = :cantidad, subtotal = :subtotal WHERE id_detalle = :id";
        try (var con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("id", id)
                .bind(detalle)
                .executeUpdate();
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM detalle_boleta WHERE id_detalle = :id";
        try (var con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("id", id)
                .executeUpdate();
        }
    }
}
