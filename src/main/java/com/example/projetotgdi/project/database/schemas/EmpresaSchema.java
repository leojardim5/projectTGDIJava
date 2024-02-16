package com.example.projetotgdi.project.database.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EmpresaSchema {
    private String id;
    private String nome;
    private String emailEmpresa;
    private String password;
    private String cnpj;
    private List<ClienteSchema> clientes = new ArrayList<>();
    private SaldoSchema saldo;
    private double taxaDeOperacao;

    public EmpresaSchema(String nome, String password, String cnpj,SaldoSchema saldo, List<ClienteSchema> clientes,
            String emailEmpresa,double taxaDeOperacao) {
        this.id = UUID.randomUUID().toString();
        ;
        this.nome = nome;
        this.emailEmpresa = emailEmpresa;
        this.password = password;
        this.clientes = clientes;
        this.cnpj = cnpj;
        this.taxaDeOperacao = taxaDeOperacao;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmailEmpresa() {
        return this.emailEmpresa;
    }

    public void setEmailEmpresa(String emailEmpresa) {
        this.emailEmpresa = emailEmpresa;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<ClienteSchema> getClientes() {
        return this.clientes;
    }

    public void setClientes(List<ClienteSchema> clientes) {
        this.clientes = clientes;
    }

    public SaldoSchema getSaldo() {
        return this.saldo;
    }

    public void setSaldo(SaldoSchema saldo) {
        this.saldo = saldo;
    }

    public double getTaxaDeOperacao() {
        return this.taxaDeOperacao;
    }

    public void setTaxaDeOperacao(double taxaDeOperacao) {
        this.taxaDeOperacao = taxaDeOperacao;
    }

}
