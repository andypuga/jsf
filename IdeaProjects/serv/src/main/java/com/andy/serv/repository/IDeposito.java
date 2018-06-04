package com.andy.serv.repository;

import java.util.List;
import java.util.Optional;

import com.andy.serv.data.Deposito;


public interface IDeposito {
	public List<Deposito> findAll();
	public Deposito findOne(Integer id);
	public void save(Deposito dep);
	public void delete(Integer id);
		
}
