package com.andy.servidor.repository;

import com.andy.servidor.dtos.Ingreso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface IngresoRepo extends CrudRepository<Ingreso,Integer> {
}
