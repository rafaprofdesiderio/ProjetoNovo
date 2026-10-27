package br.com.fiap.controller;

import br.com.fiap.bo.AlunoBo;
import br.com.fiap.entities.Aluno;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    AlunoBo alunoBo = new AlunoBo();

    // Selecionar
    @GetMapping
    public ArrayList<Aluno> selecionarRs() throws SQLException, ClassNotFoundException {
        return alunoBo.selecionarBo();
    }

    // Buscar por RM
    @GetMapping("/{rm}")
    public Aluno buscarPorRmRs(@PathVariable int rm) throws SQLException, ClassNotFoundException {
        return alunoBo.buscarPorRmBo(rm);
    }

    // Inserir
    @PostMapping
    public ResponseEntity<Void> inserirRs(@RequestBody Aluno aluno) throws SQLException, ClassNotFoundException {
        alunoBo.inserirBo(aluno);

        URI location = URI.create("/aluno/" + aluno.getRm());
        return ResponseEntity.created(location).build();
    }

    // Atualizar
    @PutMapping
    public ResponseEntity<Void> atualizarRs(@RequestBody Aluno aluno ) throws SQLException, ClassNotFoundException {
        alunoBo.atualizarBo(aluno);
        return ResponseEntity.ok().build();
    }

    // Deletar
    @DeleteMapping("/{rm}")
    public ResponseEntity<Void> deletarRs(@PathVariable int rm) throws SQLException, ClassNotFoundException {
        alunoBo.deletarBo(rm);
        return ResponseEntity.ok().build();
    }
}
