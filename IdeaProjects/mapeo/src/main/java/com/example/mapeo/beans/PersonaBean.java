package com.example.mapeo.beans;

import com.example.mapeo.daos.PersonaDao;
import com.example.mapeo.dtos.Persona;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("perBean")
public class PersonaBean {
    @Autowired
    PersonaDao personaDao;
    @Getter
    @Setter
    private Persona persona;


    private List<Persona> personas;

    public List<Persona> getPersonas() {
        return (List<Persona>) personaDao.findAll();
    }

    public void crear(){
        personaDao.save(persona);
    }
}
