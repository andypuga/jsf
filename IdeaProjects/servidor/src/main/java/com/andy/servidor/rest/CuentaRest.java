package com.andy.servidor.rest;

import java.util.Optional;

import com.andy.servidor.dtos.Cuenta;
import com.andy.servidor.repository.CuentaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/cuenta")
public class CuentaRest {
	@Autowired
	CuentaRepo cuent;
	@RequestMapping("/lista")
	public Iterable<Cuenta>  allCreditos() {
		return cuent.findAll();
	}
	@RequestMapping(value="/uno/{id}",method=RequestMethod.GET)
	public Optional<Cuenta> onebanco(@PathVariable Integer id) {
		return cuent.findById(id);
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void saveBanco(@RequestBody Cuenta cuenta ){
	    cuent.save(cuenta);  
	}
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public void updatebanco(@PathVariable Integer id, @RequestBody Cuenta cuenta){
	    Cuenta cuentaser = cuent.findById(id).get();
	    cuentaser.setIdCuenta(cuenta.getIdCuenta());
	    cuentaser.setNumCuenta(cuenta.getNumCuenta());
	    cuentaser.setDetalle(cuenta.getDetalle());
	    cuentaser.setIdPersona(cuenta.getIdPersona());
	    cuentaser.setValorTotal(cuenta.getValorTotal());
	    cuent.save(cuentaser);
	}
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id){
	    cuent.deleteById(id);
	}
} 
