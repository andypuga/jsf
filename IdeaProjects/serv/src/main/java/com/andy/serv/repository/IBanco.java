package com.andy.serv.repository;

import java.util.List;
import java.util.Optional;

import com.andy.serv.data.Banco;



public interface IBanco {
	public List<Banco> findAll();
	public Banco findOne(Integer id);
	public void save(Banco ban);
	public void delete(Integer id);
		
}
