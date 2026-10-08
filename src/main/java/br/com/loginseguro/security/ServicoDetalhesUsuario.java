package br.com.loginseguro.security;

import br.com.loginseguro.user.RepositorioUsuario;
import java.util.Locale;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ServicoDetalhesUsuario implements UserDetailsService {
    private final RepositorioUsuario users;

    public ServicoDetalhesUsuario(RepositorioUsuario users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        var account = users.findByEmail(
                username.trim().toLowerCase(Locale.ROOT))
                .orElseThrow(() -> new UsernameNotFoundException(
                        "Credenciais inválidas"));

        return User.withUsername(account.getEmail())
                .password(account.getPasswordHash())
                .authorities(account.getRoles().stream()
                        .map(role -> "ROLE_" + role.name())
                        .toArray(String[]::new))
                .disabled(!account.isEnabled())
                .build();
    }
}
