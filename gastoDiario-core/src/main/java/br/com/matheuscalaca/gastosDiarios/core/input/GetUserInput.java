package br.com.matheuscalaca.gastosDiarios.core.input;

import br.com.matheuscalaca.gastosDiarios.core.domain.User;

public interface GetUserInput {

    User execute(String email);
}
