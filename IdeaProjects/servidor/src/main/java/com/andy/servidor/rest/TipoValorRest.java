package com.andy.servidor.rest;

import java.util.Optional;

import com.andy.servidor.dtos.TipoValor;
import com.andy.servidor.repository.TipoValoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/tipovalor")
public class TipoValorRest {
	@Autowired
	TipoValoRepo tiva;
	@RequestMapping("/lista")
	public Iterable<TipoValor>  allCreditos() {
		return tiva.findAll();
	}
	@RequestMapping(value="/uno/{id}",method=RequestMethod.GET)
	public Optional<TipoValor> oneingreso(@PathVariable Integer id) {
		return tiva.findById(id);
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void saveBanco(@RequestBody TipoValor tipoValor ){
	    tiva.save(tipoValor);  
	}
	@RequestMapping(value = "/actualizar/{id}", method = RequestMethod.PUT)
	public void updatebanco(@PathVariable Integer id, @RequestBody TipoValor tipoValor){
		TipoValor tipoValorser = tiva.findById(id).get();
	 tiva.save(tipoValorser);
	}
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id){
	    tiva.deleteById(id);
	}
}
