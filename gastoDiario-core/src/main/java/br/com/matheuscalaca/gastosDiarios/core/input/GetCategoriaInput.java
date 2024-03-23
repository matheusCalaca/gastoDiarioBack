package br.com.matheuscalaca.gastosDiarios.core.input;

import br.com.matheuscalaca.gastosDiarios.core.domain.Categoria;

import java.util.List;

public interface GetCategoriaInput {
    public List<Categoria> all();
}
