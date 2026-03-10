package com.saude.consultorioapi;

import java.util.List;

public interface HistoricoConsultas {

    void adicionar(Consulta consulta, Paciente paciente);
    List<Consulta>obterLista(Paciente paciente);
}
