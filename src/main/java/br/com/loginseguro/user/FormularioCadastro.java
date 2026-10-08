package br.com.loginseguro.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class FormularioCadastro {
    @NotBlank(message = "Escolha Aluno ou Professor.")
    @Pattern(regexp = "ALUNO|PROFESSOR", message = "Escolha Aluno ou Professor.")
    private String perfil;

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    @NotBlank(message = "Informe seu nome.")
    @Size(min = 2, max = 80,
            message = "O nome deve ter entre 2 e 80 caracteres.")
    private String displayName;

    @NotBlank(message = "Informe seu e-mail.")
    @Email(message = "Informe um e-mail válido.")
    @Size(max = 254,
            message = "O e-mail deve ter no máximo 254 caracteres.")
    private String email;

    @NotBlank(message = "Informe uma senha.")
    @Size(min = 9, max = 72,
            message = "A senha deve ter entre 9 e 72 caracteres.")
    @Pattern(regexp = "(?s)(?=.*[0-9])(?=.*[\\p{P}\\p{S}]).*",
            message = "A senha deve conter pelo menos um número e um caractere especial.")
    private String password;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
