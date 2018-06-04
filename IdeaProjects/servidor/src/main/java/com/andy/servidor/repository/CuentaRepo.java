package com.andy.servidor.repository;

import com.andy.servidor.dtos.Cuenta;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Component;


@Component
public interface CuentaRepo extends CrudRepository<Cuenta, Integer>{

}
