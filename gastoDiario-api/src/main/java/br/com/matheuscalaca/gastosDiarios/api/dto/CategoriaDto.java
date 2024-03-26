package br.com.matheuscalaca.gastosDiarios.api.dto;

import java.time.LocalDate;

public class CategoriaDto {

    private Long userId;
    private String nome;
    private Long valor;
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

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
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
