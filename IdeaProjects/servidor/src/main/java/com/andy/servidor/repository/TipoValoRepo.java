package com.andy.servidor.repository;

import com.andy.servidor.dtos.TipoValor;
import org.springframework.data.repository.CrudRepository;



import org.springframework.stereotype.Component;


@Component
public interface TipoValoRepo  extends CrudRepository<TipoValor, Integer>{

}
