package com.andy.serv.rest;

import  java.util.List;
import java.util.function.Supplier;

import com.andy.serv.data.Deposito;
import com.andy.serv.repository.IDeposito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class DepositoRest {
	@Autowired
	IDeposito depo;
	@RequestMapping("/deposito/lista")
	public List<Deposito>  allCreditos() {
		return depo.findAll();
	}
	@RequestMapping(value="/deposito/uno/{id}",method=RequestMethod.GET)
	public Deposito  onebanco( @PathVariable Integer id) {
		return depo.findOne(id);
	}
	@RequestMapping(value = "/deposito/save", method = RequestMethod.POST)
	public void saveBanco(@RequestBody Deposito deposito ){
	    depo.save(deposito);  
	}

	@RequestMapping(value = "/deposito/update/{id}", method = RequestMethod.PUT)
	public void updatebanco(@PathVariable Integer id, @RequestBody Deposito deposito){
	    Deposito depositoser = depo.findOne(id);
	    depo.save(depositoser);
	}
	@RequestMapping(value="/deposito/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id){
	    depo.delete(id);
	}
}
