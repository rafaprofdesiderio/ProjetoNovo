package br.com.fiap.controller;

import br.com.fiap.bo.AlunoBo;
import br.com.fiap.entities.Aluno;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLException;
import java.util.ArrayList;

 // Controller MVC destinado às páginas HTML renderizadas pelo Thymeleaf

@Controller
@RequestMapping("/alunos")
public class AlunoWebController {

    private final AlunoBo alunoBo = new AlunoBo();

    @GetMapping
    public String listar(Model model) throws SQLException, ClassNotFoundException {
        model.addAttribute("alunos", alunoBo.selecionarBo());
        return "alunos/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("aluno", new Aluno());
        model.addAttribute("titulo", "Cadastrar aluno");
        model.addAttribute("acao", "/alunos/salvar");
        return "alunos/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("aluno") Aluno aluno,
                         RedirectAttributes redirectAttributes) {
        try {
            alunoBo.inserirBo(aluno);
            redirectAttributes.addFlashAttribute("sucesso", "Aluno cadastrado com sucesso!");
            return "redirect:/alunos";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Não foi possível cadastrar o aluno: ");
            return "redirect:/alunos/novo";
        }
    }

    @GetMapping("/editar/{rm}")
    public String editar(@PathVariable int rm, Model model,
                         RedirectAttributes redirectAttributes) throws SQLException, ClassNotFoundException {
        Aluno aluno = alunoBo.buscarPorRmBo(rm);
        if (aluno == null) {
            redirectAttributes.addFlashAttribute("erro", "Aluno não encontrado para o RM " + rm + ".");
            return "redirect:/alunos";
        }
        model.addAttribute("aluno", aluno);
        model.addAttribute("titulo", "Editar aluno");
        model.addAttribute("acao", "/alunos/atualizar");
        return "alunos/formulario";
    }

    @PostMapping("/atualizar")
    public String atualizar(@ModelAttribute("aluno") Aluno aluno,
                            RedirectAttributes redirectAttributes) {
        try {
            alunoBo.atualizarBo(aluno);
            redirectAttributes.addFlashAttribute("sucesso", "Aluno atualizado com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Não foi possível atualizar o aluno: ");
        }
        return "redirect:/alunos";
    }

    @PostMapping("/excluir/{rm}")
    public String excluir(@PathVariable int rm, RedirectAttributes redirectAttributes) {
        try {
            alunoBo.deletarBo(rm);
            redirectAttributes.addFlashAttribute("sucesso", "Aluno excluído com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Não foi possível excluir o aluno: ");
        }
        return "redirect:/alunos";
    }

}
