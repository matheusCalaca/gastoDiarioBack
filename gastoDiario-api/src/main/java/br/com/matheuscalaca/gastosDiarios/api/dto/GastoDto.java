package br.com.matheuscalaca.gastosDiarios.api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GastoDto {

    private Long userId;
    private String nome;
    private BigDecimal valor;
    private LocalDate data;
    private Long categoriaId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    @Override
    public String toString() {
        return "GastoDto{" +
                "userId=" + userId +
                ", nome='" + nome + '\'' +
                ", valor=" + valor +
                ", data=" + data +
                ", categoriaId=" + categoriaId +
                '}';
    }
}
