package com.andy.servidor.rest;

import java.util.Optional;

import com.andy.servidor.dtos.Egreso;
import com.andy.servidor.repository.EgresoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController("/egreso")
public class EgresoRest {
	@Autowired
	EgresoRepo egre;

	@RequestMapping("/lista")
	public Iterable<Egreso>  allCreditos() {
		return egre.findAll();
	}
	@RequestMapping(value="/uno/{id}",method=RequestMethod.GET)
	public Optional<Egreso> onebanco(@PathVariable Integer id) {
		return egre.findById(id);
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void saveBanco(@RequestBody Egreso egreso ){
		egre.save(egreso);
	}
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public void updatebanco(@PathVariable Integer id, @RequestBody Egreso egreso){
		Egreso egresoser = egre.findById(id).get();
		/*
		egresoser.setIdEgresos(egreso.getIdEgresos());
		egresoser.setDetalle(egreso.getDetalle());
		egresoser.setIdBanco(egreso.getIdBanco());
		egresoser.setIdTipovalor(egreso.getIdTipovalor());
		egresoser.setMemo(egreso.getMemo());
		egresoser.setValor(egreso.getValor());*/
		egre.save(egresoser);
	}
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id){
		egre.deleteById(id);
	}
}
