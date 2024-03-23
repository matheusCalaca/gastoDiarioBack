package br.com.matheuscalaca.gastosDiarios.core.output;

import br.com.matheuscalaca.gastosDiarios.core.domain.User;
import br.com.matheuscalaca.gastosDiarios.core.domain.UserAuthetication;

public interface UserOutput {

    public void creat(User user, String password);
    public UserAuthetication findByEmail(String email);

}
