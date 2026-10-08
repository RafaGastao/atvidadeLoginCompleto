package br.com.loginseguro.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorArea {
    @GetMapping("/painel")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/aluno/inicio")
    public String alunoArea() {
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
