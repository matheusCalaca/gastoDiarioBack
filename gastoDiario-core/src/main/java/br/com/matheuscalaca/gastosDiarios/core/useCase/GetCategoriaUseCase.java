package br.com.matheuscalaca.gastosDiarios.core.useCase;

import br.com.matheuscalaca.gastosDiarios.core.domain.Categoria;
import br.com.matheuscalaca.gastosDiarios.core.domain.EnumTipoEntrada;
import br.com.matheuscalaca.gastosDiarios.core.input.GetCategoriaInput;
import br.com.matheuscalaca.gastosDiarios.core.output.CategoriaOutput;

import java.util.List;

public class GetCategoriaUseCase implements GetCategoriaInput {

    private CategoriaOutput categoriaOutput;

    public GetCategoriaUseCase(CategoriaOutput categoriaOutput) {
        this.categoriaOutput = categoriaOutput;
    }

    @Override
    public List<Categoria> allByEntrada(EnumTipoEntrada entrada) {
        return categoriaOutput.allByEntrada(entrada);
    }
}
