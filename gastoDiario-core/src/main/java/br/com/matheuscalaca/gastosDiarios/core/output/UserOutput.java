package br.com.matheuscalaca.gastosDiarios.core.output;

import br.com.matheuscalaca.gastosDiarios.core.domain.User;
import br.com.matheuscalaca.gastosDiarios.core.domain.UserAuthetication;

public interface UserOutput {

     void creat(User user, String password);
     UserAuthetication findByEmail(String email);
     User findUserByEmail(String email);

}
