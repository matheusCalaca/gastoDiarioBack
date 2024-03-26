package br.com.matheuscalaca.gastosDiarios.core.input;

import br.com.matheuscalaca.gastosDiarios.core.domain.Ganho;
import br.com.matheuscalaca.gastosDiarios.core.domain.Gasto;

public interface CreateGanhoInput {
    public Ganho execute(Ganho gasto);
}
