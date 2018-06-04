package com.andy.serv.rest;

import com.andy.serv.data.TipoValor;
import com.andy.serv.repository.ITipoValor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController()
public class TipoValorRest {
	@Autowired
	ITipoValor tiva;
	@RequestMapping("/tipovalor/lista")
	public List<TipoValor> allCreditos() {
		return tiva.findAll();
	}
	@RequestMapping(value="/tipovalor/uno/{id}",method=RequestMethod.GET)
	public TipoValor oneingreso( @PathVariable Integer id) {
		return tiva.findOne(id);
	}
	@RequestMapping(value = "/tipovalor/save", method = RequestMethod.POST)
	public void saveBanco(@RequestBody TipoValor tipoValor ){
	    tiva.save(tipoValor);  
	}
	@RequestMapping(value = "/tipovalor/actualizar/{id}", method = RequestMethod.PUT)
	public void updatebanco(@PathVariable Integer id, @RequestBody TipoValor tipoValor){
		TipoValor tipoValorser = tiva.findOne(id);
	 tiva.save(tipoValorser);
	}
	@RequestMapping(value="/tipovalor/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id){
	    tiva.delete(id);
	}
}
