package br.com.loginseguro.user;

import java.time.Instant;
import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
@TypeAlias("br.com.loginseguro.user.AppUser")
public class Usuario {
    @Id
    private String id;

    @Indexed(unique = true)
    private String email;

    private String displayName;
    private String passwordHash;
    private Set<Perfil> roles;
    private boolean enabled = true;
    private Instant createdAt = Instant.now();

    protected Usuario() {
    }

    public Usuario(
            String email,
            String displayName,
            String passwordHash,
            Set<Perfil> roles) {
        this.email = email;
        this.displayName = displayName;
        this.passwordHash = passwordHash;
        this.roles = Set.copyOf(roles);
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public Set<Perfil> getRoles() {
        return roles;
    }

    public void tornarProfessor() {
        if (!roles.contains(Perfil.ADMIN)) {
            roles = Set.of(Perfil.PROFESSOR);
        }
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
