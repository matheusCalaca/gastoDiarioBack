package br.com.matheuscalaca.gastosDiarios.core.input;

import br.com.matheuscalaca.gastosDiarios.core.domain.Categoria;
import br.com.matheuscalaca.gastosDiarios.core.domain.EnumTipoEntrada;

import java.util.List;

public interface GetCategoriaInput {
    public List<Categoria> allByEntrada(EnumTipoEntrada entrada);
}
