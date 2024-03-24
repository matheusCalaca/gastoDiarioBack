package br.com.matheuscalaca.gastosDiarios.core.input;

import br.com.matheuscalaca.gastosDiarios.core.domain.Gasto;
import br.com.matheuscalaca.gastosDiarios.core.domain.ResumoGasto;
import br.com.matheuscalaca.gastosDiarios.core.domain.User;

import java.util.List;

public interface GetResumoGastoUserByMonthInput {

    ResumoGasto execute(User user, Integer month, Integer year);
}
