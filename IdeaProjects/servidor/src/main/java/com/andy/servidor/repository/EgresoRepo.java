package com.andy.servidor.repository;

import com.andy.servidor.dtos.Egreso;
import org.springframework.data.repository.CrudRepository;


import org.springframework.stereotype.Component;


@Component
public interface EgresoRepo extends CrudRepository<Egreso, Integer>{

}
