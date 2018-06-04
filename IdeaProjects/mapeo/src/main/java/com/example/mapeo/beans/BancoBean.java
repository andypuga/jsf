package com.example.mapeo.beans;

import com.example.mapeo.daos.BancoDao;
import com.example.mapeo.dtos.Banco;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BancoBean {
    @Autowired
    BancoDao bancoDao;

    private Banco banco;

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    private List<Banco> bancos;

    public List<Banco> getBancos() {
        return (List<Banco>) bancoDao.findAll();
    }

    public void crear(){
        bancoDao.save(banco);

    }
}
