package br.com.loginseguro.user;

import java.text.Normalizer;
import java.util.Locale;
import java.util.Set;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ServicoUsuario {
    private final RepositorioUsuario users;
    private final PasswordEncoder passwordEncoder;

    public ServicoUsuario(
            RepositorioUsuario users,
            PasswordEncoder passwordEncoder) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario register(FormularioCadastro form) {
        if (!"ALUNO".equals(form.getPerfil()) && !"PROFESSOR".equals(form.getPerfil())) {
            throw new IllegalArgumentException("Escolha Aluno ou Professor.");
        }
        String email = form.getEmail()
                .trim()
                .toLowerCase(Locale.ROOT);

        if (users.existsByEmail(email)) {
            throw new EmailJaCadastradoException();
        }

        String name = Normalizer.normalize(
                form.getDisplayName().trim(),
                Normalizer.Form.NFKC);

        String encodedPassword = passwordEncoder.encode(form.getPassword());
        Usuario newUser = new Usuario(
                email,
                name,
                encodedPassword,
                Set.of(Perfil.valueOf(form.getPerfil())));

        return users.save(newUser);
    }
}
