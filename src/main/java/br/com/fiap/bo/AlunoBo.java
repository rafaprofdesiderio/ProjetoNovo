package br.com.fiap.bo;

import br.com.fiap.dao.AlunoDAO;
import br.com.fiap.entities.Aluno;

import java.sql.SQLException;
import java.util.ArrayList;

public class AlunoBo {

    AlunoDAO alunoDAO;

    // Selecionar
    public ArrayList<Aluno> selecionarBo() throws SQLException, ClassNotFoundException {
      alunoDAO = new AlunoDAO();
      // Regra de negocios
        return (ArrayList<Aluno>)  alunoDAO.selecionar();
    }

    // Buscar por RM
    public Aluno buscarPorRmBo(int rm) throws SQLException, ClassNotFoundException {
        AlunoDAO alunoDao = new AlunoDAO();
        //Regra de negocios
        return alunoDao.buscarPorRm(rm);
    }

    // Inserir
    public void inserirBo(Aluno aluno) throws SQLException, ClassNotFoundException {
        AlunoDAO alunoDao = new AlunoDAO();
        //Regra de negocios
         alunoDao.inserir(aluno);
    }

    // Atualizar
    public void atualizarBo(Aluno aluno) throws SQLException, ClassNotFoundException {
        AlunoDAO alunoDao = new AlunoDAO();
        //Regra de negocios
        alunoDao.atualizar(aluno);
    }

    // Deletar
    public void deletarBo(int rm) throws SQLException, ClassNotFoundException {
        AlunoDAO alunoDao = new AlunoDAO();
        //Regra de negocios
        alunoDao.deletar(rm);
    }

}
