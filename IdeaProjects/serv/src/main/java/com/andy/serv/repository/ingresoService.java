package com.andy.serv.repository;


import com.andy.serv.data.Ingresos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ingresoService implements IIngreso{
@Autowired
IngresoRepo dao;
	@Override
	public List<Ingresos> findAll() {
		// TODO Auto-generated method stub
		return (List<Ingresos>) dao.findAll();
	}

	@Override
	public Ingresos findOne(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public void save(Ingresos dep) {
		// TODO Auto-generated method stub
		dao.save(dep);	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

}
