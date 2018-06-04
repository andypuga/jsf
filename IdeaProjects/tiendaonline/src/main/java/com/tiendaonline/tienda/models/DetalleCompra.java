package com.spring.tienda.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_compra")
public class DetalleCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer cantidad;
	private BigDecimal subtotal;
	private BigDecimal total;
	
	@ManyToOne
	@JoinColumn(name = "compra_id")
	private Compra compraId;
	
	@ManyToOne
	@JoinColumn(name = "articulo_id")
	private Articulo articuloId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Compra getCompraId() {
		return compraId;
	}

	public void setCompraId(Compra compraId) {
		this.compraId = compraId;
	}

	public Articulo getArticuloId() {
		return articuloId;
	}

	public void setArticuloId(Articulo articuloId) {
		this.articuloId = articuloId;
	}
	
	
}
