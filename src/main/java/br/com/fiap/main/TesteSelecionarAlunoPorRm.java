package br.com.fiap.main;

import br.com.fiap.entities.Aluno;
import br.com.fiap.dao.AlunoDAO;


import javax.swing.*;
import java.sql.SQLException;

public class TesteSelecionarAlunoPorRm {

    // inteiro
    static int inteiro(String j){
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Aluno objAluno = new Aluno();

        AlunoDAO dao = new AlunoDAO();

        objAluno.setRm(inteiro("Informe o RM do aluno para consulta"));

        Aluno resultado = dao.buscarPorRm(objAluno.getRm());

        if (resultado != null) {
            System.out.println(resultado);
        } else {
            JOptionPane.showMessageDialog(null, "RM " + objAluno.getRm() + " não encontrado no banco de dados.");
        }
    }
}
