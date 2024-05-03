package br.com.matheuscalaca.gastosDiarios.api.dto;

public class JwtRequestDto {

    private String jwt;

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
