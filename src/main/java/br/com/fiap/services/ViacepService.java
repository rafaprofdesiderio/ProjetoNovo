package br.com.fiap.services;

import br.com.fiap.api.Endereco;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ViacepService {

    public Endereco getEndereco(String cep) throws IOException {

        Endereco endereco = null;

        // request  HtG
        HttpGet resquest  = new HttpGet("https://viacep.com.br/ws/"+cep+"/json/");

        // client   CHC                  HCB                        drh
        CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();

        // response CHR
        CloseableHttpResponse response = httpClient.execute(resquest);

        // entity   Hte
        HttpEntity entity = response.getEntity();

        if(entity != null){
                       //  Entiu
           String result = EntityUtils.toString(entity);

           // Instanciar o Gson
            Gson gson = new Gson();

            // endereco recebe o resultado com a ajuda do gson
            endereco =  gson.fromJson(result , Endereco.class);
        }
        return endereco;
    }
}
