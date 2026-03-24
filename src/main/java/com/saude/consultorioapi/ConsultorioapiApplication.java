package com.saude.consultorioapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.net.ssl.*;
import java.io.IOException;



@SpringBootApplication
public class ConsultorioapiApplication {

    private static ApiService apiService;

    public static void main(String[] args) throws IOException {

        //Questão 1
        System.out.println("Questão 1:");
        obterLista();
        //Questão 2
        System.out.println("Questão 2:");
        obterEntidadeEspecifica(2);
        //Questão 3
        System.out.println("Questão 3:");
        obterEntidadeEspecifica(13);
        //Questão 4
        System.out.println("Questão 4:");
        obterPorCategoriaELimite("teste",5);
        //Questão 5
        System.out.println("Questão 5:");



    }
    // GET simples de todas as entidades
    private static void obterLista() throws IOException{
        apiService = new ApiService();

        ApiResponse response = apiService.httpRequest("/sim/entities", "GET");

        System.out.println(response);

    }

    // GET de entidade específica
    private static void obterEntidadeEspecifica(int id) throws IOException{
        apiService = new ApiService();

        ApiResponse response = apiService.httpRequest("/sim/entities/"+id, "GET");

        System.out.println(response);

    }

    // GET com parâmetros na URL
    private static void obterPorCategoriaELimite(String categoria, int limite) throws IOException{
        apiService = new ApiService();

        ApiResponse response = apiService.httpRequest("/sim/entities?categoria="+categoria+"&limite="+limite, "GET");

        System.out.println(response);

    }

    // POST criando uma nova entidade
    private static void criarEntidade() throws IOException{
        apiService = new ApiService();

        ApiResponse response = apiService.httpRequest("", "POST");

        System.out.println(response);

    }
}
