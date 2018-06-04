/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andy.servidor.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Programador3
 */
@Entity
@Table(name = "persona")
@Data
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PERSONA")

    private Integer idPersona;
    @Column(name = "NOMBRES")

    private String nombres;
    @Column(name = "FECHA_NACI")
    @Temporal(TemporalType.DATE)

    private Date fechaNaci;
    @Column(name = "VALOR_AHORRO")

    private Long valorAhorro;
    @Column(name = "TRABAJA")

    private Boolean trabaja;
    @Column(name = "REFERENCIA_")

    private String referencia;
    @Column(name = "DESCRIPCION")

    private String descripcion;
    @Column(name = "IDENTIFICACION")

    private String identificacion;
    @Column(name = "CONTRASENA")

    private String contrasena;


    public Persona() {
    }

}
