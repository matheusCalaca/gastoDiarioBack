package br.com.matheuscalaca.gastosDiarios.core.output;

import br.com.matheuscalaca.gastosDiarios.core.domain.Categoria;
import br.com.matheuscalaca.gastosDiarios.core.domain.EnumTipoEntrada;

import java.util.List;

public interface CategoriaOutput {

    public List<Categoria> allByEntrada(EnumTipoEntrada entrada);

}
