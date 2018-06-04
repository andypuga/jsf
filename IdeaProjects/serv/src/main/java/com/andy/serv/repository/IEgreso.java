package com.andy.serv.repository;

import java.util.List;
import java.util.Optional;


import com.andy.serv.data.Egresos;



public interface IEgreso {
	public List<Egresos> findAll();
	public Egresos findOne(Integer id);
	public void save(Egresos dep);
	public void delete(Integer id);
}
