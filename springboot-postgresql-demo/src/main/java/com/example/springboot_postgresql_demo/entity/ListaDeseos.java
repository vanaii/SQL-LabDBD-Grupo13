package com.example.springboot_postgresql_demo.entity;

public class ListaDeseos {
    private Integer idDeseo;
    private Integer idUsuario;
    private Integer idProducto;

    public Integer getIdDeseo() {
        return idDeseo;
    }

    public void setIdDeseo(Integer idDeseo) {
        this.idDeseo = idDeseo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}
