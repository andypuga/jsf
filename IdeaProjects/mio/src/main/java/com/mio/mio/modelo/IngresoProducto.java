package com.example.demo.modelo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ingreso_producto")
public class IngresoProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id ;
    private Integer catidad;
    @Column(name = "fecha_ingreso")
    private Date fechaIngreso;
            @ManyToOne
            @JoinColumn(name = "articulo")
            private Articulo articulo;
    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCatidad() {
        return catidad;
    }

    public void setCatidad(Integer catidad) {
        this.catidad = catidad;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
