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
        criarEntidade("aluno");
        //Questão 6
        System.out.println("Questão 6:");
        obterEntidadeEspecifica(11);
        //Questão 7
        System.out.println("Questão 7:");
        atualizarEntidade("atualizado",10);
        //Questão 8
        System.out.println("Questão 8:");
        alterarEntidade("atualizado",10);
        //Questão 9
        System.out.println("Questão 9:");
        excluirEntidade(9);
        obterEntidadeEspecifica(9);
        //Questão 10
        System.out.println("Questão 10:");
        excluirEntidade(2);
        //Questão 11
        System.out.println("Questão 11:");
        obterOptions();



    }
    // GET simples de todas as entidades
    private static void obterLista() throws IOException{
        apiService = new ApiService();

        ApiResponse response = apiService.httpRequest("/sim/entities", "GET", null, null);

        System.out.println(response);

    }

    // GET de entidade específica
    private static void obterEntidadeEspecifica(int id) throws IOException{
        apiService = new ApiService();

        ApiResponse response = apiService.httpRequest("/sim/entities/"+id, "GET", null, null);

        System.out.println(response);

    }

    // GET com parâmetros na URL
    private static void obterPorCategoriaELimite(String categoria, int limite) throws IOException{
        apiService = new ApiService();

        ApiResponse response = apiService.httpRequest("/sim/entities?categoria="+categoria+"&limite="+limite, "GET", null, null);

        System.out.println(response);

    }

    // POST criando uma nova entidade
    private static void criarEntidade(String nome) throws IOException{
        apiService = new ApiService();

        String payload = String.format("{\";name\": \"%s\"}", nome);

        ApiResponse response = apiService.httpRequest("/sim/entities", "POST", payload, null);

        System.out.println(response);

    }

    //POST para atualizar uma entidade
    private static void atualizarEntidade(String nome, int id) throws IOException{
        apiService = new ApiService();

        String payload = String.format("{\";name\": \"%s\"}", nome);

        ApiResponse response = apiService.httpRequest("/sim/entities/"+id, "POST", payload, null);

        System.out.println(response);

    }

    //PUT para atualizar entidade
    private static void alterarEntidade(String nome, int id) throws IOException{
        apiService = new ApiService();

        String payload = String.format("{\";name\": \"%s\"}", nome);

        ApiResponse response = apiService.httpRequest("/sim/entities/"+id, "PUT", payload, null);

        System.out.println(response);

    }

    // DELETE de entidade válida
    private static void excluirEntidade(int id) throws IOException{
        apiService = new ApiService();

        ApiResponse response = apiService.httpRequest("/sim/entities/"+id, "DELETE", null, null);

        System.out.println(response);
    }

    // OPTIONS com verificação de métodos
    private static void obterOptions() throws IOException{
        apiService = new ApiService();

        ApiResponse response = apiService.httpRequest("/sim/entities/", "OPTIONS", null, null);

        System.out.println(response);
    }
}
