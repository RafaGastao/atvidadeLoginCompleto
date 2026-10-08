package br.com.loginseguro.web;

import br.com.loginseguro.user.NivelJogo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorArea {
    @GetMapping("/painel")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/aluno/inicio")
    public String alunoArea(@RequestParam(required = false) NivelJogo nivel, Model model) {
        model.addAttribute("nivelSelecionado", nivel);
        return "areas/aluno";
    }

    @GetMapping("/professor/inicio")
    public String professorArea() {
        return "areas/professor";
    }

    @GetMapping("/usuario/inicio")
    public String antigoAluno() {
        return "redirect:/aluno/inicio";
    }

    @GetMapping("/editor/inicio")
    public String antigoProfessor() {
        return "redirect:/professor/inicio";
    }
}
