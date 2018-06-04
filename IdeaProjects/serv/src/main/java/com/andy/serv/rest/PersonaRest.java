package com.andy.serv.rest;
import com.andy.serv.data.Persona;
import com.andy.serv.repository.IPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Supplier;


@RestController()

public class PersonaRest {
	@Autowired
    IPersona per;
	
	@RequestMapping("/persona/lista")
	public List<Persona> allpersonas() {
		
		return per.findAll();
	}
	
	@RequestMapping(value="/persona/uno/{id}",method=RequestMethod.GET)
	public Persona  onepersona( @PathVariable Integer id) {
		return (Persona) per.findOne(id);
 
	}
	
    @RequestMapping(value = "/persona/save", method = RequestMethod.POST)
    public void saveProduct(@RequestBody Persona persona){
        per.save(persona);
       
    }
 
 
  @RequestMapping(value = "/persona/update/{id}", method = RequestMethod.PUT)
    public void updatepersona(@PathVariable Integer id, @RequestBody Persona persona){
        Persona personaser = per.findOne(id);

        personaser.setNombres(persona.getNombres());
        personaser.setContrasena(persona.getContrasena());
        personaser.setDescripcion(persona.getDescripcion());
        personaser.setFechaNaci(persona.getFechaNaci());
        personaser.setIdentificacion(persona.getIdentificacion());
        personaser.setTrabaja(persona.getTrabaja());
        personaser.setValorAhorro(persona.getValorAhorro());
        personaser.setReferencia(persona.getReferencia());
        per.save(personaser);
  }
        
  
    @RequestMapping(value="/persona/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id){
        per.delete(id);
      
 
    }
	
}
