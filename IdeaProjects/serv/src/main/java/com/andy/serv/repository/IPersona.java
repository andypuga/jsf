package com.andy.serv.repository;


import com.andy.serv.data.Persona;

import java.util.List;

public interface IPersona {
	public List<Persona> findAll();
	public Persona findOne(Integer id);
	public void save(Persona per);
	public void delete(Integer id);
		
}
