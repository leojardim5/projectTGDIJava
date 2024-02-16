
package com.example.projetotgdi.project.database.repositories;

import java.util.ArrayList;
import java.util.List;

import com.example.projetotgdi.project.database.schemas.ClienteSchema;
import com.example.projetotgdi.project.database.schemas.EmpresaSchema;

public class ClienteRepository {
    private EmpresaRepository empresaRepository;
    private static List<ClienteSchema> clientes = new ArrayList<>();

    public List<ClienteSchema> findAll() {
        return clientes;
    }

    public ClienteSchema findById(String id) {
        for (ClienteSchema cliente : clientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    public void save(ClienteSchema cliente) {
        clientes.add(cliente);
    }

    public void update(String id, ClienteSchema clienteAtualizado) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId().equals(id)) {
                clientes.set(i, clienteAtualizado);
                break;
            }
        }
    }

    public void delete(String id) {
        clientes.removeIf(cliente -> cliente.getId().equals(id));
    }

    

    public String saque(double valor, String cnpj, String idCliente) {
        ClienteSchema cliente = findById(idCliente);
        EmpresaSchema empresa = empresaRepository.findByCnpj(cnpj);

        if (cliente != null && empresa != null) {
            List<EmpresaSchema> empresasDoCliente = cliente.getEmpresas();
            boolean empresaDoClienteEncontrada = false;

            for (EmpresaSchema empresaCliente : empresasDoCliente) {
                if (empresaCliente.getId().equals(cnpj)) {
                    empresaDoClienteEncontrada = true;
                    break;
                }
            }

            if (empresaDoClienteEncontrada) {
                double saldoDisponivel = empresa.getSaldo().getValor();

                if (saldoDisponivel >= valor) {
                    double valorComTaxa = valor * (1 - empresa.getTaxaDeOperacao());
                    double novoSaldo = saldoDisponivel - valorComTaxa;
                    cliente.setSaldo(novoSaldo);
                    empresa.getSaldo().setValor(empresa.getSaldo().getValor() + valorComTaxa);
                }
            } else {
                return "Empresa nao entcontrada";
            }

        }
        return "Saque feito com sucesso";
        }

    public String deposito(double valor, String cnpj, String idCliente) {
        ClienteSchema cliente = findById(idCliente);
        EmpresaSchema empresa = empresaRepository.findByCnpj(cnpj);

        if (cliente != null && empresa != null) {
            List<EmpresaSchema> empresasDoCliente = cliente.getEmpresas();
            boolean empresaDoClienteEncontrada = false;

            for (EmpresaSchema empresaCliente : empresasDoCliente) {
                if (empresaCliente.getId().equals(cnpj)) {
                    empresaDoClienteEncontrada = true;
                    break;
                }
            }

            if (empresaDoClienteEncontrada) {
                // double valorComTaxa = valor * (1 - empresa.getTaxaDeOperacao());
                // cliente.setSaldo(cliente.getSaldo()+ valorComTaxa) ;
                
                empresa.getSaldo().setValor(empresa.getSaldo().getValor() - valorComTaxa);
            } else {
                return "Clinete nao esta na empresa";
            }
        } else {
            return "NAo encontrados";
        }

        return "deposito feito";
    }
}