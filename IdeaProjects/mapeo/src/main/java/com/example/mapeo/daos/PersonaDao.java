package com.example.mapeo.daos;

import com.example.mapeo.dtos.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDao  extends CrudRepository<Persona,Integer> {
}
