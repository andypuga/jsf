package com.andy.serv.repository;
import com.andy.serv.data.Credito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CreditoService implements ICredito{
@Autowired
CreditoRepo dao;
	@Override
	public List<Credito> findAll() {
		// TODO Auto-generated method stub
		return (List<Credito>) dao.findAll();
	}

	@Override
	public Credito findOne(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public void save(Credito cred) {
		// TODO Auto-generated method stub
	dao.save(cred);	
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
	}

}
