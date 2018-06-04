package com.andy.servidor.repository;

import com.andy.servidor.dtos.Credito;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Component;


@Component
public interface CreditoRepo  extends CrudRepository<Credito, Integer>{

}
