package com.example.secure.controladores;


import com.example.secure.datos.Cuenta;
import com.example.secure.datos.Persona;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("cuenBean")
public class CuentaMb {
    private Persona persona;
    private Cuenta cuenta;
    private List<Persona> personas;
    private List<Cuenta> cuentas;

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }


    public List<Cuenta> getCuentas() throws IOException {

        DepositoMb dp = new DepositoMb();
        cuentas = dp.getCuentas();
        return cuentas;
    }

    public List<SelectItem> getListaPersonas() throws IOException {

        PersonaMb dp = new PersonaMb();
        List<Persona> pers = dp.getPersonas();
        System.out.println(pers.toString());
        List<SelectItem> items = new ArrayList();
        pers.forEach((cuenta) -> {
            items.add(new SelectItem(cuenta.getIdPersona(), cuenta.getNombres()));
        });
        return items;

    }

    @PostConstruct
    public void init() {
        persona = new Persona();
        cuenta = new Cuenta();
        cuenta.setIdPersona(new Persona());
    }

    public void nuevo() {
        persona = new Persona();
        cuenta = new Cuenta();
        cuenta.setIdPersona(new Persona());

    }

    public void buscar(int id) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Integer> params = new HashMap<>();
        params.put("id", id);
        Cuenta cuen = new Cuenta();
        cuen = restTemplate.getForObject("http://localhost:8081/cuenta/uno/{id}", Cuenta.class, params);
        cuenta = cuen;
    }

    public void guardar() {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Integer> params = new HashMap<>();
        params.put("id", persona.getIdPersona());
        Persona per = new Persona();
        per = restTemplate.getForObject("http://localhost:8081/persona/uno/{id}", Persona.class, params);
        persona = per;
        cuenta.setIdPersona(per);
        restTemplate.postForObject("http://localhost:8081/cuenta/save", cuenta, Cuenta.class);
    }

    public void eliminar(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("id", id);
        restTemplate.delete("http://localhost:8081/cuenta/delete/{id}", id);

    }


}
