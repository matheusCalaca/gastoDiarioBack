package br.com.matheuscalaca.gastosDiarios.core.useCase;

import br.com.matheuscalaca.gastosDiarios.core.domain.Categoria;
import br.com.matheuscalaca.gastosDiarios.core.domain.Gasto;
import br.com.matheuscalaca.gastosDiarios.core.exception.ValidException;
import br.com.matheuscalaca.gastosDiarios.core.input.CreateGastoInput;
import br.com.matheuscalaca.gastosDiarios.core.input.GetCategoriaInput;
import br.com.matheuscalaca.gastosDiarios.core.output.CategoriaOutput;
import br.com.matheuscalaca.gastosDiarios.core.output.GastoOutput;

import java.time.LocalDate;
import java.util.List;

public class GetCategoriaUseCase implements GetCategoriaInput {

    private CategoriaOutput categoriaOutput;

    public GetCategoriaUseCase(CategoriaOutput categoriaOutput) {
        this.categoriaOutput = categoriaOutput;
    }

    @Override
    public List<Categoria> all() {
        return categoriaOutput.all();
    }
}
