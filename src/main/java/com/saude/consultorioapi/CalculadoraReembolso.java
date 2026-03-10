package com.saude.consultorioapi;

public class CalculadoraReembolso {

    private Auditoria auditoria;
    private AutorizadorReembolso autorizadorReembolso;


    public CalculadoraReembolso(Auditoria auditoria, AutorizadorReembolso autorizadorReembolso) {
        this.auditoria = auditoria;
        this.autorizadorReembolso = autorizadorReembolso;

    }

    public double calcularReembolso(Consulta consulta, Paciente paciente, PlanoSaude planoSaude) {

        if(!autorizadorReembolso.isAutorizado(consulta, paciente)) { throw new ReembolsoNaoAutorizadoException("Reembolso nao permitido"); }

        double reembolso = consulta.getValor() * planoSaude.getPercentualCobertura();

        auditoria.registrarConsulta(consulta, paciente);
        return reembolso;
    }

    public double calcularReembolsoTeto(Consulta consulta, Paciente paciente, PlanoSaude planoSaude) {

        if(!autorizadorReembolso.isAutorizado(consulta, paciente)) { throw new ReembolsoNaoAutorizadoException("Reembolso nao permitido"); }

        double reembolso = consulta.getValor() * planoSaude.getPercentualCobertura();

        auditoria.registrarConsulta(consulta, paciente);

        if(reembolso >=150) { return 150; }

        return reembolso;
    }


}