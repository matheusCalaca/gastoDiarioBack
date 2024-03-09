package br.com.matheuscalaca.gastosDiarios.core.input;

import br.com.matheuscalaca.gastosDiarios.core.domain.Gasto;
import br.com.matheuscalaca.gastosDiarios.core.domain.User;

import java.time.LocalDate;
import java.util.List;

public interface GetGastoUserByMonthInput {

    public List<Gasto> execute(User user, Integer month, Integer year);
}
