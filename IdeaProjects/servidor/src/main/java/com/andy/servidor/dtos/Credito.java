/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andy.servidor.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 *
 * @author Programador3
 */
@Entity
@Table(name = "credito")
@Data
public class Credito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID_CREDITO")
    private Integer idCredito;

    @Column(name = "DETALLE")
    private String detalle;
    @Column(name = "VALOR")
    private Long valor;
    @Column(name = "INTERES")
    private Long interes;
    @Column(name = "TOTAL")
    private Long total;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "PLAZO")
    private Integer plazo;

    private Cuenta idCuenta;

    public Credito() {
    }


    
}
