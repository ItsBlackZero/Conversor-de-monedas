package modelos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LogicaHttp {

    public HttpResponse peticion(String moneda , String monedaAConvertir) throws IOException, InterruptedException {

        String url = "https://v6.exchangerate-api.com/v6/0644b66b6b8175ec6c894301/pair/"+moneda+"/"+monedaAConvertir;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        return  response;
    }


}