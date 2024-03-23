package br.com.matheuscalaca.gastosDiarios.core.input;

import br.com.matheuscalaca.gastosDiarios.core.domain.Categoria;
import br.com.matheuscalaca.gastosDiarios.core.domain.User;

import java.util.List;

public interface GetUserByEmailInput {
    public User execute(String email);
}
