package br.com.matheuscalaca.gastosDiarios.core.useCase;

import br.com.matheuscalaca.gastosDiarios.core.domain.User;
import br.com.matheuscalaca.gastosDiarios.core.domain.UserAuthetication;
import br.com.matheuscalaca.gastosDiarios.core.exception.ValidException;
import br.com.matheuscalaca.gastosDiarios.core.input.CreateUserInput;
import br.com.matheuscalaca.gastosDiarios.core.input.GetUserInput;
import br.com.matheuscalaca.gastosDiarios.core.output.UserOutput;


public class GetUserUseCase implements GetUserInput {

    private UserOutput userOutput;

    public GetUserUseCase(UserOutput userOutput) {
        this.userOutput = userOutput;
    }

    @Override
    public User execute(String email) {
        return userOutput.findUserByEmail(email);
    }

}
