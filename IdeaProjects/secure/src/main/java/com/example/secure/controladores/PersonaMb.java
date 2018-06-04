package com.example.secure.controladores;

import com.example.secure.datos.Persona;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("perBean")
public class PersonaMb {
    private List<Persona> personas = new ArrayList<>();
    private Persona persona;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getPersonas() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Persona>> mapType = new TypeReference<List<Persona>>() {
        };
        String consulta;
        consulta = restTemplate.getForObject("http://localhost:8081/persona/lista", String.class);
        personas = objectMapper.readValue(consulta, mapType);
        return personas;

    }

    public void nuevo() {
        persona = new Persona();
        //personas= new ArrayList<>();

    }

    public void buscar(int id) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Integer> params = new HashMap<>();
        params.put("id", id);
        Persona per = new Persona();
        per = restTemplate.getForObject("http://localhost:8081/persona/uno/{id}", Persona.class, params);
        persona = per;


    }

    public void guardar() {
        RestTemplate restTemplate = new RestTemplate();
        System.out.print(persona.toString());
        restTemplate.postForObject("http://localhost:8081/persona/save", persona, Persona.class);

    }

    public void eliminar(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("id", id);
        restTemplate.delete("http://localhost:8081/persona/delete/{id}", id);

    }


}
