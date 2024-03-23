package br.com.matheuscalaca.gastosDiarios.core.input;

import br.com.matheuscalaca.gastosDiarios.core.domain.Categoria;
import br.com.matheuscalaca.gastosDiarios.core.domain.User;
import br.com.matheuscalaca.gastosDiarios.core.domain.UserAuthetication;

import java.util.List;

public interface GetUserByEmailInput {
    public UserAuthetication execute(String email);
}
