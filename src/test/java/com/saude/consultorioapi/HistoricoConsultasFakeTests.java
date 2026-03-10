package com.saude.consultorioapi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HistoricoConsultasFakeTests {

    private HistoricoConsultasFake historicoConsultasFake;

    @BeforeEach
    public void setUp() {
        historicoConsultasFake = new HistoricoConsultasFake();
        historicoConsultasFake.limpar();
    }

    @Test
    void deveAdicionarConsultaAoHistorico() {

        Paciente paciente = new Paciente();

        Consulta consulta1 = new Consulta(100);
        Consulta consulta2 = new Consulta(200);

        int quantidadeConsultas = 2;

        historicoConsultasFake.adicionar(consulta1, paciente);
        historicoConsultasFake.adicionar(consulta2, paciente);
        List<Consulta> consultas = historicoConsultasFake.obterLista(paciente);

        assertEquals(quantidadeConsultas, consultas.size());
    }
}
