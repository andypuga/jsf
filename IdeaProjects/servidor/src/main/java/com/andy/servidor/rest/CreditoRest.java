package com.andy.servidor.rest;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Optional;

import com.andy.servidor.dtos.Credito;
import com.andy.servidor.repository.CreditoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/credito")
public class CreditoRest {
	@Autowired
	CreditoRepo cred;
	@RequestMapping("/lista")
	public Iterable<Credito>  allCreditos() {
		return cred.findAll();
	}
	@RequestMapping(value="/uno/{id}",method=RequestMethod.GET)
	public Optional<Credito> onebanco(@PathVariable Integer id) {
		return cred.findById(id);
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void saveBanco(@RequestBody Credito credito ){
	    cred.save(credito);  
	}
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public void updatebanco(@PathVariable Integer id, @RequestBody Credito credito){
	    //Optional<Credito> creditolist= cred.findById(id);
		Collection c = Collections.singleton(cred.findById(id));

		Iterator iter = c.iterator();

		Object primero = iter.next();

	    Credito creditoser = (Credito) primero;

		creditoser.setIdCredito(credito.getIdCredito());
	    creditoser.setDetalle(credito.getDetalle());
	    creditoser.setFecha(credito.getFecha());
	    creditoser.setIdCuenta(credito.getIdCuenta());
	    creditoser.setInteres(credito.getInteres());
	    creditoser.setPlazo(credito.getPlazo ());
	    creditoser.setTotal(credito.getTotal());
	    creditoser.setValor(credito.getValor());
	    cred.save(creditoser);
	}
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id){
	    cred.deleteById(id);
	}
}
