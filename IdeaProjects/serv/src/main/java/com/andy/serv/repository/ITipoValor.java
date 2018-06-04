package com.andy.serv.repository;

import com.andy.serv.data.TipoValor;

import java.util.List;
import java.util.Optional;

public interface ITipoValor {
	public List<TipoValor> findAll();
	public TipoValor findOne(Integer id);
	public void save(TipoValor dep);
	public void delete(Integer id);
}
