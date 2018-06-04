package com.andy.serv.repository;


import com.andy.serv.data.Deposito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DepositoService  implements IDeposito{
@Autowired
DepositoRepo dao;

	@Override
	public List<Deposito> findAll() {
		// TODO Auto-generated method stub
		return (List<Deposito>) dao.findAll();
	}

	@Override
	public Deposito findOne(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public void save(Deposito dep) {
		// TODO Auto-generated method stub
		dao.save(dep);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

}
