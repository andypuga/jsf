package com.andy.serv.repository;

import java.util.List;
import java.util.Optional;

import com.andy.serv.data.Cuenta;



public interface ICuenta {
	public List<Cuenta> findAll();
	public Cuenta findOne(Integer id);
	public void save(Cuenta cuen);
	public void delete(Integer id);
		
}
