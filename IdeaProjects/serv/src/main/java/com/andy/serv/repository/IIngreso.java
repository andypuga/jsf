package com.andy.serv.repository;


import com.andy.serv.data.Ingresos;

import java.util.List;
import java.util.Optional;

public interface IIngreso {
	public List<Ingresos> findAll();
	public Ingresos findOne(Integer id);
	public void save(Ingresos dep);
	public void delete(Integer id);
}
