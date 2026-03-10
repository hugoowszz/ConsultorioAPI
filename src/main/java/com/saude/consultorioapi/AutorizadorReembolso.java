package com.saude.consultorioapi;

public interface AutorizadorReembolso {

    boolean isAutorizado(Consulta consulta, Paciente paciente);
}
