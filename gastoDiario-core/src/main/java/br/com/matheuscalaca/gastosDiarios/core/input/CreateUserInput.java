package br.com.matheuscalaca.gastosDiarios.core.input;

import br.com.matheuscalaca.gastosDiarios.core.domain.User;

public interface CreateUserInput {

    public User execute(User user);
}
