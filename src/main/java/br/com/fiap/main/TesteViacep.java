package br.com.fiap.main;

import br.com.fiap.api.Endereco;
import br.com.fiap.services.ViacepService;

import javax.swing.*;
import java.io.IOException;

public class TesteViacep {

    // String
    static String texto(String j){
        return JOptionPane.showInputDialog(j);
    }

    // Java 21  psvm   // Java 25 public psvma
    public static void main(String[] args) throws IOException {

        ViacepService viacepService = new ViacepService();

        String cep = texto("Informe o numero do CEP para busca");

        Endereco endereco = viacepService.getEndereco(cep);

        System.out.print(endereco);
    }
}
