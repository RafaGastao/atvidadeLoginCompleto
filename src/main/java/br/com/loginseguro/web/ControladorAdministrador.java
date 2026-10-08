package br.com.loginseguro.web;

import br.com.loginseguro.user.RepositorioUsuario;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class ControladorAdministrador {
    private final RepositorioUsuario users;

    public ControladorAdministrador(RepositorioUsuario users) {
        this.users = users;
    }

    @GetMapping("/admin/inicio")
    public String inicio(Model model) {
        model.addAttribute("contas", users.findAll());
        return "areas/admin";
    }

    @PostMapping("/admin/usuarios/{id}/professor")
    public String tornarProfessor(@PathVariable String id) {
        var conta = users.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        conta.tornarProfessor();
        users.save(conta);
        return "redirect:/admin/inicio?atualizado";
    }
}
