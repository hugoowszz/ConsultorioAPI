package com.saude.consultorioapi;

public class AuditoriaSpy implements Auditoria {

    private boolean consultaRegistrada = false;
    private Consulta ultimaConsulta;
    private Paciente ultimoPaciente;

    @Override
    public void registrarConsulta(Consulta consulta, Paciente paciente) {
        consultaRegistrada = true;
        ultimaConsulta = consulta;
        ultimoPaciente = paciente;
    }

    public void limpar() {
        consultaRegistrada = false;
        ultimaConsulta = null;
        ultimoPaciente = null;
    }

    public boolean isConsultaRegistrada() {
        return consultaRegistrada;
    }

    public Consulta getUltimaConsulta() {
        return ultimaConsulta;
    }

    public Paciente getUltimoPaciente() {
        return ultimoPaciente;
    }
}
