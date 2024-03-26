package br.com.matheuscalaca.gastosDiarios.core.output;

import br.com.matheuscalaca.gastosDiarios.core.domain.Ganho;
import br.com.matheuscalaca.gastosDiarios.core.domain.Gasto;
import br.com.matheuscalaca.gastosDiarios.core.domain.User;

import java.util.List;

public interface GanhoOutput {
    void creat(Ganho ganho);

    List<Ganho> findByUserAndMonth(User user, Integer month, Integer year);

}
