package com.andy.serv.repository;


import com.andy.serv.data.Egresos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EgresoService  implements IEgreso{
@Autowired
EgresoRepo dao;
	@Override
	public List<Egresos> findAll() {
		// TODO Auto-generated method stub
		return (List<Egresos>) dao.findAll();
	}

	@Override
	public Egresos findOne(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public void save(Egresos dep) {
		// TODO Auto-generated method stub
		dao.save(dep);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}
}
