package com.example.springboot_postgresql_demo.repository;

import com.example.springboot_postgresql_demo.entity.Usuario;
import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;
import org.sql2o.Connection;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository {

    private final Sql2o sql2o;

    public UsuarioRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public List<Usuario> listar() {
        String sql = "SELECT * FROM usuario";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Usuario.class);
        }
    }

    public Optional<Usuario> buscarPorId(Integer id) {
        String sql = "SELECT * FROM usuario WHERE id_usuario = :id";
        try (Connection con = sql2o.open()) {
            Usuario u = con.createQuery(sql)
                .addParameter("id", id)
                .executeAndFetchFirst(Usuario.class);
            return Optional.ofNullable(u);
        }
    }

    public Usuario guardar(Usuario usuario) {
        String sql = "INSERT INTO usuario (nombre, correo, password, rol, ubicacion) " +
                     "VALUES (:nombre, :correo, :password, :rol, :ubicacion)";
        try (Connection con = sql2o.open()) {
            Integer id = con.createQuery(sql, true)
                .addParameter("nombre", usuario.getNombre())
                .addParameter("correo", usuario.getCorreo())
                .addParameter("password", usuario.getPassword())
                .addParameter("rol", usuario.getRol())
                .addParameter("ubicacion", usuario.getUbicacion())
                .executeUpdate()
                .getKey(Integer.class);
            usuario.setIdUsuario(id);
            return usuario;
        }
    }

    public void actualizar(Integer id, Usuario usuario) {
        String sql = "UPDATE usuario SET nombre=:nombre, correo=:correo, password=:password, rol=:rol, ubicacion=:ubicacion WHERE id_usuario=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("nombre", usuario.getNombre())
                .addParameter("correo", usuario.getCorreo())
                .addParameter("password", usuario.getPassword())
                .addParameter("rol", usuario.getRol())
                .addParameter("ubicacion", usuario.getUbicacion())
                .addParameter("id", id)
                .executeUpdate();
        }
    }

    public void eliminar(Integer id) {
        String sql = "DELETE FROM usuario WHERE id_usuario = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("id", id)
                .executeUpdate();
        }
    }

    public Optional<Usuario> buscarPorCorreo(String correo) {
        String sql = "SELECT * FROM usuario WHERE correo = :correo";
        try (Connection con = sql2o.open()) {
            return Optional.ofNullable(
                con.createQuery(sql)
                .addParameter("correo", correo)
                .executeAndFetchFirst(Usuario.class)
            );
        }
    }
}
