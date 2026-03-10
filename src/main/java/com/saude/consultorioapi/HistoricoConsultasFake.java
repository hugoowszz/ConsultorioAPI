package com.saude.consultorioapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoricoConsultasFake implements HistoricoConsultas {

    private Map<Paciente, List<Consulta>> historico = new HashMap<Paciente, List<Consulta>>();

    @Override
    public void adicionar(Consulta consulta, Paciente paciente) {

        historico.computeIfAbsent(paciente,  k  ->  new ArrayList<Consulta>()).add(consulta);
    }

    @Override
    public List<Consulta> obterLista(Paciente paciente) {

        return historico.getOrDefault(paciente, new ArrayList<Consulta>());
    }

    public void limpar() {
        historico.clear();
    }
}
