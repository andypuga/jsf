package com.andy.serv.rest;

import java.util.List;
import java.util.function.Supplier;

import com.andy.serv.data.Cuenta;
import com.andy.serv.repository.ICuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class CuentaRest {
	@Autowired
	ICuenta cuent;
	@RequestMapping("/cuenta/lista")
	public List<Cuenta>  allCreditos() {
		return cuent.findAll();
	}
	@RequestMapping(value="/cuenta/uno/{id}",method=RequestMethod.GET)
	public Cuenta  onebanco( @PathVariable Integer id) {
		return cuent.findOne(id);
	}
	@RequestMapping(value = "/cuenta/save", method = RequestMethod.POST)
	public void saveBanco(@RequestBody Cuenta cuenta ){
	    cuent.save(cuenta);  
	}
	@RequestMapping(value = "/cuenta/update/{id}", method = RequestMethod.PUT)
	public void updatebanco(@PathVariable Integer id, @RequestBody Cuenta cuenta){
	    Cuenta cuentaser = cuent.findOne(id);
	    cuentaser.setIdCuenta(cuenta.getIdCuenta());
	    cuentaser.setNumCuenta(cuenta.getNumCuenta());
	    cuentaser.setDetalle(cuenta.getDetalle());
	    cuentaser.setIdPersona(cuenta.getIdPersona());
	    cuentaser.setValorTotal(cuenta.getValorTotal());
	    cuent.save(cuentaser);
	}
	@RequestMapping(value="/cuenta/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id){
	    cuent.delete(id);
	}
} 
