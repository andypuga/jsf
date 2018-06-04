package com.andy.servidor.rest;

import com.andy.servidor.dtos.Persona;
import com.andy.servidor.repository.PersonaRepo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController("/persona")
public class PersonaRest {
	@Autowired
    PersonaRepo per;
	@Getter
    @Setter
	private Persona persona;
	
	@RequestMapping("/lista")
	public Iterable<Persona>  allpersonas() {
		
		return per.findAll();
	}
	
	@RequestMapping(value="/uno/{id}",method=RequestMethod.GET)
	public Persona  onepersona( @PathVariable Integer id) {
		return per.findById(id).get();
 
	}
	
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void saveProduct(@RequestBody Persona persona){
        per.save(persona);
       
    }
  @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public void updatepersona(@PathVariable Integer id, @RequestBody Persona persona){
        Persona personaser = per.findById(id).get();
        /*
        personaser.setNombres(persona.getNombres());
        personaser.setContrasena(persona.getContrasena());
        personaser.setDescripcion(persona.getDescripcion());
        personaser.setFechaNaci(persona.getFechaNaci());
        personaser.setIdentificacion(persona.getIdentificacion());
        personaser.setTrabaja(persona.getTrabaja());
        personaser.setValorAhorro(persona.getValorAhorro());
        personaser.setReferencia(persona.getReferencia());*/
        per.save(personaser);
  }
        
  @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id){
        per.deleteById(id);
      
 
    }
	
}
