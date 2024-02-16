
package com.example.projetotgdi.project.database.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ClienteSchema {
    private String id;
    private String nome;
    private String email;
    private String cpf;
    private List<EmpresaSchema> empresas = new ArrayList<>();
    private double saldo;

   

   
    public ClienteSchema(String nome, String email, String cpf, List<EmpresaSchema> empresas) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.empresas = empresas;
    }

     public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<EmpresaSchema> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<EmpresaSchema> empresas) {
        this.empresas = empresas;
    }
}