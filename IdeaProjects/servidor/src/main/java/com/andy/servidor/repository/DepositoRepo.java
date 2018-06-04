package com.andy.servidor.repository;


import com.andy.servidor.dtos.Deposito;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Component;


@Component
public interface DepositoRepo extends CrudRepository<Deposito, Integer> {

}
