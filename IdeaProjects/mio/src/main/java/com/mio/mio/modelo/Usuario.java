package com.example.demo.modelo;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id ;

    private String email;
    private String nombres;
    private String apellidos;
    private String Password;
    private String telefono;
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;
    @ManyToOne
    @JoinColumn(name="rol")
    private Rol rol;

}
