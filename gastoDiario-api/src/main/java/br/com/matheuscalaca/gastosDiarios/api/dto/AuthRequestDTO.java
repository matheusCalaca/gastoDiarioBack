package br.com.matheuscalaca.gastosDiarios.api.dto;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AuthRequestDTO {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
