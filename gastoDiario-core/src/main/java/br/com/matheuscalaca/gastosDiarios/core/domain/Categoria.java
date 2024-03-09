package br.com.matheuscalaca.gastosDiarios.core.domain;

public class Categoria {
    private Long id;
    private String Categoria;

    public Categoria(Long categoriaId) {
        this.id = categoriaId;
    }

    public Categoria() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }
}
