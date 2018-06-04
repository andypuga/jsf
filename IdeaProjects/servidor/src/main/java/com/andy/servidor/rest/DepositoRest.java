package com.andy.servidor.rest;

import java.util.Optional;

import com.andy.servidor.dtos.Deposito;
import com.andy.servidor.repository.DepositoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/deposito")
public class DepositoRest {
	@Autowired
	DepositoRepo depo;
	@RequestMapping("/lista")
	public Iterable<Deposito>  allCreditos() {
		return depo.findAll();
	}
	@RequestMapping(value="/uno/{id}",method=RequestMethod.GET)
	public Optional<Deposito> onebanco(@PathVariable Integer id) {
		return depo.findById(id);
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void saveBanco(@RequestBody Deposito deposito ){
	    depo.save(deposito);  
	}
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public void updatebanco(@PathVariable Integer id, @RequestBody Deposito deposito){
	    Deposito depositoser = depo.findById(id).get();

	    depo.save(depositoser);
	}
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id){
	    depo.deleteById(id);
	}
}
