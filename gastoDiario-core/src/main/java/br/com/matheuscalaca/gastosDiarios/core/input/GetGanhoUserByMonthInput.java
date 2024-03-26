package br.com.matheuscalaca.gastosDiarios.core.input;

import br.com.matheuscalaca.gastosDiarios.core.domain.Ganho;
import br.com.matheuscalaca.gastosDiarios.core.domain.Gasto;
import br.com.matheuscalaca.gastosDiarios.core.domain.User;

import java.util.List;

public interface GetGanhoUserByMonthInput {

    public List<Ganho> execute(User user, Integer month, Integer year);
}
