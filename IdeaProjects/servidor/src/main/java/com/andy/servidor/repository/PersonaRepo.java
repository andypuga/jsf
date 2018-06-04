package com.andy.servidor.repository;

import com.andy.servidor.dtos.Persona;
import org.springframework.data.repository.CrudRepository;




import org.springframework.stereotype.Component;


@Component
public interface PersonaRepo extends CrudRepository<Persona, Integer>{

}
