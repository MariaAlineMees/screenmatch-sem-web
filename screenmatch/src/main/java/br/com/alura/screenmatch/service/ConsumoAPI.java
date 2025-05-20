package br.com.alura.screenmatch.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// Essa classe é responsável por fazer requisições HTTP para consumir dados de uma API e retornar o corpo da resposta como uma String.
public class ConsumoAPI {
    public String obterDados(String endereco) { //Define um método público chamado obterDados, que recebe como parâmetro uma String endereco (a URL da API) e retorna uma String com os dados (geralmente no formato JSON).
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco)) //dizer para qual endereco fazer a requisicao
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();
        return json;
    }
}

/* IOException: usada para tratar erros de entrada e saída (por exemplo, falha ao acessar a internet).

        URI: representa um endereço da web (Uniform Resource Identifier).

        HttpClient: a classe que realiza a requisição HTTP.

        HttpRequest: representa os dados da requisição (endereço, cabeçalhos, corpo, etc).

        HttpResponse: representa a resposta recebida da API.

*/
