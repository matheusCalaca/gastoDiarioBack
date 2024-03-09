package br.com.matheuscalaca.gastosDiarios.core.output;

import br.com.matheuscalaca.gastosDiarios.core.domain.Gasto;
import br.com.matheuscalaca.gastosDiarios.core.domain.User;

import java.util.List;

public interface GastoOutput {
    void creat(Gasto gasto);

    List<Gasto> findByUserAndMonth(User user, Integer month);

}
