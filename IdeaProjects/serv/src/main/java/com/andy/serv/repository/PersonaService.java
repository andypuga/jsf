package com.andy.serv.repository;


import com.andy.serv.data.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService  implements IPersona{
@Autowired
PersonaRepo dao;

@Override
public List<Persona> findAll() {
	List<Persona> personas = (List<Persona>) dao.findAll();
	return personas;
}

@Override
public Persona findOne(Integer id) {
	return dao.findById(id).get();
	}

@Override
public void save(Persona per) {
	dao.save(per);
	
}

@Override
public void delete(Integer id) {
	dao.deleteById(id);
	
}

	

	
}
