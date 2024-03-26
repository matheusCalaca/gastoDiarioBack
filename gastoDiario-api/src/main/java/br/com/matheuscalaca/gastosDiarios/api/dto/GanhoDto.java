package br.com.matheuscalaca.gastosDiarios.api.dto;

import br.com.matheuscalaca.gastosDiarios.core.domain.Categoria;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GanhoDto {

    private Long userId;
    private BigDecimal valor;
    private LocalDate data;
    private Long categoriaId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
}
