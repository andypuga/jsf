package com.example.secure.controladores;

import com.example.secure.datos.Cuenta;
import com.example.secure.datos.Deposito;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component("depBean")
public class DepositoMb {
    private Deposito deposito;
    private Cuenta cuenta;
    private List<Deposito> depositos;
    private List<Cuenta> cuentas;

    public List<Cuenta> getCuentas() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Cuenta>> mapType = new TypeReference<List<Cuenta>>() {
        };
        String consulta2;
        consulta2 = restTemplate.getForObject("http://localhost:8081/cuenta/lista", String.class);
        cuentas = objectMapper.readValue(consulta2, mapType);

        return cuentas;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Deposito getDeposito() {
        return deposito;
    }

    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;
    }

    public List<Deposito> getDepositos() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Deposito>> mapType = new TypeReference<List<Deposito>>() {
        };
        String consulta;
        consulta = restTemplate.getForObject("http://localhost:8081/deposito/lista", String.class);
        depositos = objectMapper.readValue(consulta, mapType);
        return depositos;

    }


    public List<SelectItem> getListaCuentas() throws IOException {
        DepositoMb dp = new DepositoMb();

        List<Cuenta> cuent = dp.getCuentas();
        System.out.println(cuent.toString());
        List<SelectItem> items = new ArrayList();
        cuent.forEach((cuenta) -> {
            items.add(new SelectItem(cuenta.getIdCuenta(), cuenta.getNumCuenta()));
        });
        return items;

    }

    @PostConstruct
    public void init() {
        deposito = new Deposito();
        deposito.setIdCuenta(new Cuenta());
        deposito.setValor((long) 0.00);
        cuenta = new Cuenta();
    }

    public void nuevo() {
        deposito = new Deposito();
        deposito.setIdCuenta(new Cuenta());
        deposito.setValor((long) 0.00);
        cuenta = new Cuenta();

    }

    public void buscar(int id) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Integer> params = new HashMap<>();
        params.put("id", id);
        Deposito dep = new Deposito();
        dep = restTemplate.getForObject("http://localhost:8081/deposito/uno/{id}", Deposito.class, params);
        deposito = dep;


    }

    public void guardar() {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, Integer> params = new HashMap<>();
        params.put("id", cuenta.getIdCuenta());
        Cuenta cuen = new Cuenta();
        cuen = restTemplate.getForObject("http://localhost:8081/cuenta/uno/{id}", Cuenta.class, params);
        cuenta = cuen;
        deposito.setIdCuenta(cuenta);
        restTemplate.postForObject("http://localhost:8081/deposito/save", deposito, Deposito.class);


    }

    public void eliminar(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("id", id);
        restTemplate.delete("http://localhost:8081/deposito/delete/{id}", id);

    }

}
