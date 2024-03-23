package br.com.matheuscalaca.gastosDiarios.api.dto;

import java.time.LocalDate;

public class CategoriaDto {

    private Long userId;
    private String nome;
    private Long valor;
    private LocalDate dataCompra;
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

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
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
                ", dataCompra=" + dataCompra +
                ", categoriaId=" + categoriaId +
                '}';
    }
}
