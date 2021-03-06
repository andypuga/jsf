/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapeo.dtos;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Programador3
 */
@Entity
@Table(name = "ingreso")
@Data
public class Ingreso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_INGRESOS")
    private Integer idIngresos;
    @Column(name = "DETALLE")
    private String detalle;
    @Column(name = "VALOR")
    private Long valor;
    @Column(name = "MEMO")
    private String memo;
    private Banco idBanco;
    private Tipovalor_1 idTipovalor;
    private TipoValor idTipovalor1;
    public Ingreso() {
    }

    
}
