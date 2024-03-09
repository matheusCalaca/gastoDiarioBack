package br.com.matheuscalaca.gastosDiarios.core.useCase;

import br.com.matheuscalaca.gastosDiarios.core.domain.User;
import br.com.matheuscalaca.gastosDiarios.core.exception.ValidException;
import br.com.matheuscalaca.gastosDiarios.core.input.CreateUserInput;
import br.com.matheuscalaca.gastosDiarios.core.output.UserOutput;


public class CreateUserUseCase implements CreateUserInput {

    private UserOutput userOutput;

    public CreateUserUseCase(UserOutput userOutput) {
        this.userOutput = userOutput;

    }

    @Override
    public User execute(User user) {

        validationUser(user);

        userOutput.creat(user);
        return null;
    }

    private void validationUser(User user) {
        if(user.getCpf() == null || user.getCpf().isBlank()){
            throw new ValidException(user.getCpf());
        }

        if(user.getNome() == null || user.getNome().isBlank()){
            throw new ValidException(user.getNome());
        }

        if(user.getEmail() == null || user.getEmail().isBlank()){
            throw new ValidException(user.getEmail());
        }
    }
}
