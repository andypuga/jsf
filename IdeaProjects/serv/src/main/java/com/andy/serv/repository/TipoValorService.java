package com.andy.serv.repository;


import com.andy.serv.data.TipoValor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TipoValorService implements ITipoValor{
@Autowired
TipoValoRepo dao;
	@Override
	public List<TipoValor> findAll() {
		// TODO Auto-generated method stub
		return (List<TipoValor>) dao.findAll();
	}

	@Override
	public TipoValor findOne(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public void save(TipoValor dep) {
		// TODO Auto-generated method stub
		dao.save(dep);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

}
