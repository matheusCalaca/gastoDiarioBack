package br.com.matheuscalaca.gastosDiarios.core.input;

import br.com.matheuscalaca.gastosDiarios.core.domain.Gasto;

public interface CreateGastoInput {
    public Gasto execute(Gasto gasto);
}
