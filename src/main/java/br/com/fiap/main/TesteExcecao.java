package br.com.fiap.main;

import javax.swing.*;

public class TesteExcecao {

    public static void main(String[] args) {

        try {
            double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor"));
            System.out.println(valor);
        }catch (NumberFormatException e){
            System.out.print(" Digitado letra em campo para entrada de numero ");

        }catch (ArithmeticException e) {
            System.out.print(" Falha aritmetica na tentativa de dividir por zero ");

        }
        finally {
            System.out.println("OK");
        }




    }



}
