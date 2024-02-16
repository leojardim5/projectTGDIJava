package com.example.projetotgdi.project.database.schemas;

public class SaldoSchema {

    private double valor;
    private EmpresaSchema empresa;
    private ClienteSchema cliente;

    public ClienteSchema getCliente() {
        return this.cliente;
    }

    public void setCliente(ClienteSchema cliente) {
        this.cliente = cliente;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public EmpresaSchema getEmpresa() {
        return this.empresa;
    }

    public void setEmpresa(EmpresaSchema empresa) {
        this.empresa = empresa;
    }
}
