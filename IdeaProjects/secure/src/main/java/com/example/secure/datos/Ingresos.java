/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.secure.datos;


import java.io.Serializable;

/**
 * @author Programador3
 */

public class Ingresos implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer idIngresos;

    private String detalle;

    private Long valor;

    private String memo;

    private Banco idBanco;

    private TipoValor idTipovalor;

    public Ingresos() {
    }

    public Ingresos(Integer idIngresos) {
        this.idIngresos = idIngresos;
    }

    public Integer getIdIngresos() {
        return idIngresos;
    }

    public void setIdIngresos(Integer idIngresos) {
        this.idIngresos = idIngresos;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Banco getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Banco idBanco) {
        this.idBanco = idBanco;
    }

    public TipoValor getIdTipovalor() {
        return idTipovalor;
    }

    public void setIdTipovalor(TipoValor idTipovalor) {
        this.idTipovalor = idTipovalor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIngresos != null ? idIngresos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingresos)) {
            return false;
        }
        Ingresos other = (Ingresos) object;
        if ((this.idIngresos == null && other.idIngresos != null) || (this.idIngresos != null && !this.idIngresos.equals(other.idIngresos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Ingresos[ idIngresos=" + idIngresos + " ]";
    }

}
