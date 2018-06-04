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
public class Egresos implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idEgresos;
    private String detalle;

    private Long valor;
    private String memo;

    private Banco idBanco;

    private TipoValor idTipovalor;

    public Egresos() {
    }

    public Egresos(Integer idEgresos) {
        this.idEgresos = idEgresos;
    }

    public Integer getIdEgresos() {
        return idEgresos;
    }

    public void setIdEgresos(Integer idEgresos) {
        this.idEgresos = idEgresos;
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
        hash += (idEgresos != null ? idEgresos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Egresos)) {
            return false;
        }
        Egresos other = (Egresos) object;
        if ((this.idEgresos == null && other.idEgresos != null) || (this.idEgresos != null && !this.idEgresos.equals(other.idEgresos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Egresos[ idEgresos=" + idEgresos + " ]";
    }

}
