package com.example.projetotgdi.project.database.repositories;

import java.util.ArrayList;
import java.util.List;

import com.example.projetotgdi.project.database.schemas.EmpresaSchema;

public class EmpresaRepository {
    private List<EmpresaSchema> empresas = new ArrayList<>();


    public EmpresaRepository() {
        this.empresas = new ArrayList<>();
    }

    public List<EmpresaSchema> findAll() {
        return empresas;
    }

    public EmpresaSchema findById(String id) {
        for (EmpresaSchema empresa : empresas) {
            if (empresa.getId().equals(id)) {
                return empresa;
            }
        }
        return null;
    }

    public void save(EmpresaSchema empresa) {
        empresas.add(empresa);
    }

    public EmpresaSchema findOneAndUpdate(String id, EmpresaSchema updatedEmpresa) {
        for (int i = 0; i < empresas.size(); i++) {
            EmpresaSchema empresa = empresas.get(i);
            if (empresa.getId().equals(id)) {
                empresas.set(i, updatedEmpresa);
                return updatedEmpresa;
            }
        }
        return null;
    }

    public boolean deleteById(String id) {
        for (EmpresaSchema empresa : empresas) {
            if (empresa.getId().equals(id)) {
                empresas.remove(empresa);
                return true;
            }
        }
        return false;
    }

    public EmpresaSchema findByCnpj(String cnpj) {
        for (EmpresaSchema empresa : empresas) {
            if (empresa.getId().equals(cnpj)) {
                return empresa;
            }
        }
        return null;
    }
}