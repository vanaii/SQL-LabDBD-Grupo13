package com.example.springboot_postgresql_demo.repository;

import com.example.springboot_postgresql_demo.entity.Producto;
import org.sql2o.Sql2o;
import org.sql2o.Connection;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {

    private final Sql2o sql2o;

    public ProductoRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public List<Producto> listar() {
        String sql = "SELECT * FROM producto";
        try (var con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Producto.class);
        }
    }

    public Optional<Producto> buscarPorId(Integer id) {
        String sql = "SELECT * FROM producto WHERE id_producto = :id";
        try (var con = sql2o.open()) {
            return Optional.ofNullable(
                con.createQuery(sql).addParameter("id", id).executeAndFetchFirst(Producto.class)
            );
        }
    }

    public Producto guardar(Producto p) {
        String sql = """
            INSERT INTO producto (nombre, tipo, categoria, stock, precio, ventas, url)
            VALUES (:nombre, :tipo, :categoria, :stock, :precio, :ventas, :url)
        """;
        try (var con = sql2o.open()) {
            Integer id = con.createQuery(sql, true)
                .bind(p)
                .executeUpdate()
                .getKey(Integer.class);
            p.setIdProducto(id);
            return p;
        }
    }

    public void actualizar(Integer id, Producto p) {
        String sql = """
            UPDATE producto
            SET nombre=:nombre, tipo=:tipo, categoria=:categoria, stock=:stock,
                precio=:precio, ventas=:ventas, url=:url
            WHERE id_producto=:id
        """;
        try (var con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("id", id)
                .bind(p)
                .executeUpdate();
        }
    }

    public void eliminar(Integer id) {
        String sql = "DELETE FROM producto WHERE id_producto = :id";
        try (var con = sql2o.open()) {
            con.createQuery(sql).addParameter("id", id).executeUpdate();
        }
    }

    public List<Producto> filtrarPorUbicacion(String ubicacion) {
        String sql = """
            SELECT p.*
            FROM producto p
            JOIN usuarioxproducto up ON p.id_producto = up.id_producto
            JOIN usuario u ON up.correo = u.correo
            JOIN tienda t ON u.id_tienda = t.id_tienda
            WHERE t.ubicacion_tienda = :ubicacion
        """;
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("ubicacion", ubicacion)
                    .executeAndFetch(Producto.class);
        }
    }
}