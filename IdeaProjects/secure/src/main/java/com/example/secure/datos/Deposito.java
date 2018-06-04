/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.secure.datos;


import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


/**
 * @author Programador3
 */

public class Deposito implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idDeposito;

    private Long valor;

    private String detalle;
    @Size(min = 6, max = 8)
    private String numComp;

    private Date fecha;

    private Cuenta idCuenta;

    public Deposito() {
    }

    public Deposito(Integer idDeposito) {
        this.idDeposito = idDeposito;
    }

    public Integer getIdDeposito() {
        return idDeposito;
    }

    public void setIdDeposito(Integer idDeposito) {
        this.idDeposito = idDeposito;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getNumComp() {
        return numComp;
    }

    public void setNumComp(String numComp) {
        this.numComp = numComp;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cuenta getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Cuenta idCuenta) {
        this.idCuenta = idCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDeposito != null ? idDeposito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deposito)) {
            return false;
        }
        Deposito other = (Deposito) object;
        if ((this.idDeposito == null && other.idDeposito != null) || (this.idDeposito != null && !this.idDeposito.equals(other.idDeposito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Deposito[ idDeposito=" + idDeposito + " ]";
    }

}
