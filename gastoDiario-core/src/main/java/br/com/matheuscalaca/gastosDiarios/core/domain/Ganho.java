package br.com.matheuscalaca.gastosDiarios.core.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Ganho {
    private User user;
    private Categoria categoria;
    private BigDecimal valor;
    private LocalDate data;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
