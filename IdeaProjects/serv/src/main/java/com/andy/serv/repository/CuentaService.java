package com.andy.serv.repository;


import com.andy.serv.data.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CuentaService implements ICuenta{
@Autowired
CuentaRepo dao;
	@Override
	public List<Cuenta> findAll() {
		// TODO Auto-generated method stub
		return (List<Cuenta>) dao.findAll();
	}

	@Override
	public Cuenta findOne(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public void save(Cuenta cuen) {
		// TODO Auto-generated method stub
		dao.save(cuen);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

}
