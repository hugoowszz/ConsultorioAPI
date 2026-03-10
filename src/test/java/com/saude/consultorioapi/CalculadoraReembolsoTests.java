package com.saude.consultorioapi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class CalculadoraReembolsoTests {

    private CalculadoraReembolso calculadoraReembolso;
    private AuditoriaSpy auditoriaSpy;
    private AutorizadorReembolso autorizadorReembolsoMock;

    @BeforeEach
    public void setUp() {
        auditoriaSpy = new AuditoriaSpy();
        auditoriaSpy.limpar();
        autorizadorReembolsoMock = mock(AutorizadorReembolso.class);
        calculadoraReembolso = new CalculadoraReembolso(auditoriaSpy, autorizadorReembolsoMock);
    }

    private Consulta criarConsulta(double valor) {
        Consulta consulta = new Consulta();
        consulta.setValor(valor);

        return consulta;
    }

    private Paciente criarPacienteDummy() {
        return new Paciente();
    }

    private PlanoSaude criarPlanoSaudeStub(double porcentagem) {
        return new PlanoSaude() {
            @Override
            public double getPercentualCobertura() {
                return porcentagem / 100;
            }
        };
    }

    private boolean verificarDecimais(double valor1, double valor2) {
        return Math.abs(valor1 - valor2) < 0.01;
    }

    @Test
    void deveCalcularReembolsoBasico() {

        double valorConsulta = 200;
        double percentualCobertura = 0.7;

        double resultadoEsperado = 140;
        double resultadoFinal = valorConsulta * percentualCobertura;

        assertEquals(resultadoEsperado, resultadoFinal);
    }

    @Test
    void deveCalcularReembolsoComCobertura80Porcento() {
        Consulta consulta = new Consulta(100);
        double resultadoEsperado = 80;

        Paciente paciente = new Paciente();
        PlanoSaude80PorcentoStub planoSaude = new PlanoSaude80PorcentoStub();

        when(autorizadorReembolsoMock.isAutorizado(consulta, paciente)).thenReturn(true);
        double resultadoFinal = calculadoraReembolso.calcularReembolso(consulta, paciente, planoSaude);

        assertEquals(resultadoEsperado, resultadoFinal);
        assertTrue(verificarDecimais(resultadoEsperado, resultadoFinal));
    }

    @Test
    void deveRetornarZeroSeValorConsultaForZero() {
        double valorConsulta = 0;
        double percentualCobertura = 0.5;

        double resultadoFinal = valorConsulta * percentualCobertura;

        assertEquals(0, resultadoFinal);
    }

    @Test
    void deveRetornarZeroSeCoberturaForZero() {
        double valorConsulta = 200;
        double percentualCobertura = 0;

        double resultadoFinal = valorConsulta * percentualCobertura;
        assertEquals(0, resultadoFinal);
    }

    @Test
    void deveCalcularReembolso() {
        double valorConsulta = 200;
        double resultadoEsperado = 140;

        Consulta consulta = criarConsulta(valorConsulta);
        Paciente paciente = criarPacienteDummy();


        PlanoSaude planoSaude = criarPlanoSaudeStub(70);

        when(autorizadorReembolsoMock.isAutorizado(consulta, paciente)).thenReturn(true);

        double reembolsoFinal = calculadoraReembolso.calcularReembolso(consulta, paciente, planoSaude);

        assertEquals(resultadoEsperado, reembolsoFinal, 0.001);

        assertTrue(auditoriaSpy.isConsultaRegistrada());
        assertEquals(consulta, auditoriaSpy.getUltimaConsulta());
        assertEquals(paciente, auditoriaSpy.getUltimoPaciente());

        verify(autorizadorReembolsoMock, times(1)).isAutorizado(consulta, paciente);
    }
}