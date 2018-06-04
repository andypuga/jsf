/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andy.servidor.dtos;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Size;

/**
 *
 * @author Programador3
 */
@Entity
@Table(name = "tipovalor")
@Data
public class Tipovalor_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPOVALOR")
    private Integer idTipovalor;
    @Column(name = "TIPOVALOR")
    private String tipovalor;
    @Column(name = "decimal52")
    private BigDecimal decimal52;
    @Column(name = "decimal105")
    private BigDecimal decimal105;
    @Column(name = "decimal1510")
    private BigDecimal decimal1510;


    public Tipovalor_1() {
    }


    
}
