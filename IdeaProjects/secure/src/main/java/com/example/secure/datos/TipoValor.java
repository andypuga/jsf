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

public class TipoValor implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer idTipovalor;

    private String tipovalor;

    public TipoValor() {
    }

    public TipoValor(Integer idTipovalor) {
        this.idTipovalor = idTipovalor;
    }

    public Integer getIdTipovalor() {
        return idTipovalor;
    }

    public void setIdTipovalor(Integer idTipovalor) {
        this.idTipovalor = idTipovalor;
    }

    public String getTipovalor() {
        return tipovalor;
    }

    public void setTipovalor(String tipovalor) {
        this.tipovalor = tipovalor;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipovalor != null ? idTipovalor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoValor)) {
            return false;
        }
        TipoValor other = (TipoValor) object;
        if ((this.idTipovalor == null && other.idTipovalor != null) || (this.idTipovalor != null && !this.idTipovalor.equals(other.idTipovalor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TipoValor[ idTipovalor=" + idTipovalor + " ]";
    }

}
