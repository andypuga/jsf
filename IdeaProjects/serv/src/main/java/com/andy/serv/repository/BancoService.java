package com.andy.serv.repository;

import java.util.List;
import java.util.Optional;

import com.andy.serv.data.Banco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BancoService implements IBanco{
@Autowired
BancoRepo dao;
	@Override
	public List<Banco> findAll() {
		// TODO Auto-generated method stub
		return (List<Banco>) dao.findAll();
	}

	@Override
	public Banco findOne(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public void save(Banco ban) {
		dao.save(ban);
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
	}

}
