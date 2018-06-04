package com.andy.serv.rest;

import com.andy.serv.data.Credito;
import com.andy.serv.repository.ICredito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;

@RestController()
public class CreditoRest {
	@Autowired
	ICredito cred;
	@RequestMapping("/credito/lista")
	public List<Credito> allCreditos() {
		return cred.findAll();
	}
	@RequestMapping(value="/uno/{id}",method=RequestMethod.GET)
	public Credito  onebanco( @PathVariable Integer id) {
		return cred.findOne(id);
	}
	@RequestMapping(value = "/credito/save", method = RequestMethod.POST)
	public void saveBanco(@RequestBody Credito credito ){
	    cred.save(credito);  
	}
	@RequestMapping(value = "/credito/update/{id}", method = RequestMethod.PUT)
	public void updatebanco(@PathVariable Integer id, @RequestBody Credito credito){
	    Credito creditoser = cred.findOne(id);
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
	@RequestMapping(value="/credito/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id){
	    cred.delete(id);
	}
}
