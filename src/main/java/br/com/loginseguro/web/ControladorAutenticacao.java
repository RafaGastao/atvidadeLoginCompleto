package br.com.loginseguro.web;

import br.com.loginseguro.user.EmailJaCadastradoException;
import br.com.loginseguro.user.FormularioCadastro;
import br.com.loginseguro.user.ServicoUsuario;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorAutenticacao {
    private final ServicoUsuario users;

    public ControladorAutenticacao(ServicoUsuario users) {
        this.users = users;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/cadastro")
    public String registration(Model model) {
        model.addAttribute("form", new FormularioCadastro());
        return "auth/register";
    }

    @PostMapping("/cadastro")
    public String register(
            @Valid @ModelAttribute("form") FormularioCadastro form,
            BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            return "auth/register";
        }

        try {
            users.register(form);
        } catch (EmailJaCadastradoException exception) {
            result.rejectValue(
                    "email",
                    "duplicate",
                    "Este e-mail já está cadastrado.");
            return "auth/register";
        }

        return "redirect:/login?registered";
    }
}
