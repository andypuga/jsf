package com.andy.serv.rest;


import com.andy.serv.data.Banco;
import com.andy.serv.repository.IBanco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Supplier;


@RestController("")
public class BancoRest {
@Autowired
IBanco ban;
@RequestMapping("/banco/lista")
public List<Banco> allbancos() {
	return ban.findAll();
}

@RequestMapping(value="/banco/uno/{id}",method=RequestMethod.GET)
public Banco  onebanco( @PathVariable Integer id) {

              return ban.findOne(id);

}

@RequestMapping(value = "/banco/guarda", method = RequestMethod.POST)
public void saveBanco(@RequestBody Banco banco){
    ban.save(banco);
   
}


@RequestMapping(value = "/banco/actualiza/{id}", method = RequestMethod.PUT)
public void updatebanco(@PathVariable Integer id, @RequestBody Banco banco){
    Banco bancoser = ban.findOne(id);
    bancoser.setIdBanco(banco.getIdBanco());
    bancoser.setBanco(banco.getBanco());
    bancoser.setDetalle(banco.getDetalle());
    bancoser.setNombreCuenta(banco.getNombreCuenta());
    bancoser.setValor(banco.getValor());
    ban.save(bancoser);
}
    

@RequestMapping(value="/banco/borrar/{id}", method = RequestMethod.DELETE)
public void delete(@PathVariable Integer id){
    ban.delete(id);
  

}
}
