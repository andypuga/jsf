package com.example.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
@Entity
@Table(name = "detalle_compra")
public class DetalleCompra {

private Integer Catidad;
private        BigDecimal subtotal;
private BigDecimal total;
    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuarioId;

    @ManyToOne
    @JoinColumn(name="articulo_id")
    private Articulo articuloId;


}
