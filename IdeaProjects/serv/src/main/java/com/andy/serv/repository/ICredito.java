package com.andy.serv.repository;

import java.util.List;
import java.util.Optional;

import com.andy.serv.data.Credito;



public interface ICredito {
	public List<Credito> findAll();
	public Credito findOne(Integer id);
	public void save(Credito cred);
	public void delete(Integer id);
		
}
