package com.andy.servidor.rest;


import com.andy.servidor.dtos.Banco;
import com.andy.servidor.repository.BancoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController("/banco")
public class BancoRest {
@Autowired
BancoRepo ban;
@RequestMapping("/lista")
public Iterable<Banco>  allbancos() {
	return ban.findAll();
}

@RequestMapping(value="/uno/{id}",method=RequestMethod.GET)
public Optional<Banco> onebanco(@PathVariable Integer id) {
	return ban.findById(id);

}

@RequestMapping(value = "/save", method = RequestMethod.POST)
public void saveBanco(@RequestBody Banco banco){
    ban.save(banco);
   
}


@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
public void updatebanco(@PathVariable Integer id, @RequestBody Banco banco){
    Banco bancoser =   ban.findById(id).get();
    bancoser.setIdBanco(banco.getIdBanco());
    bancoser.setBanco(banco.getBanco());
    bancoser.setDetalle(banco.getDetalle());
    bancoser.setNombreCuenta(banco.getNombreCuenta());
    bancoser.setValor(banco.getValor());
    ban.save(bancoser);
}
    

@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
public void delete(@PathVariable Integer id){
    ban.deleteById(id);
  

}
}
