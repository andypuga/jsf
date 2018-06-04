package com.andy.servidor.repository;

import com.andy.servidor.dtos.Banco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


@Component
public interface BancoRepo extends CrudRepository<Banco, Integer>{

}
