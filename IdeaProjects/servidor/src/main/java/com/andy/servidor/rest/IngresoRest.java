package com.andy.servidor.rest;

import java.util.Optional;

import com.andy.servidor.dtos.Ingreso;
import com.andy.servidor.repository.IngresoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController("/ingreso")
public class IngresoRest {
	@Autowired
	IngresoRepo ingre;
	@RequestMapping("/lista")
	public Iterable<Ingreso>  allCreditos() {
		return ingre.findAll();
	}
	@RequestMapping(value="/uno/{id}",method=RequestMethod.GET)
	public Optional<Ingreso> oneingreso(@PathVariable Integer id) {
		return ingre.findById(id);
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void saveBanco(@RequestBody Ingreso ingreso ){
	    ingre.save(ingreso);  
	}
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public void updatebanco(@PathVariable Integer id, @RequestBody Ingreso ingreso){
	 Ingreso ingresoser = ingre.findById(id).get();
	 ingresoser.setIdIngresos(ingreso.getIdIngresos());
	 ingresoser.setIdBanco(ingreso.getIdBanco());
	 ingresoser.setDetalle(ingreso.getDetalle());
	 ingresoser.setIdTipovalor(ingreso.getIdTipovalor());
	 ingresoser.setValor(ingreso.getValor());
	 ingresoser.setMemo(ingreso.getMemo());
	 ingre.save(ingresoser);
	}
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id){
	    ingre.deleteById(id);
	}
}
