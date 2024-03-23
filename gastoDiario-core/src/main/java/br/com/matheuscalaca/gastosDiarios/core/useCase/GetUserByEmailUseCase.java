package br.com.matheuscalaca.gastosDiarios.core.useCase;

import br.com.matheuscalaca.gastosDiarios.core.domain.Categoria;
import br.com.matheuscalaca.gastosDiarios.core.domain.User;
import br.com.matheuscalaca.gastosDiarios.core.input.GetCategoriaInput;
import br.com.matheuscalaca.gastosDiarios.core.input.GetUserByEmailInput;
import br.com.matheuscalaca.gastosDiarios.core.output.CategoriaOutput;
import br.com.matheuscalaca.gastosDiarios.core.output.UserOutput;

import java.util.List;

public class GetUserByEmailUseCase implements GetUserByEmailInput {

    private UserOutput userOutput;

    public GetUserByEmailUseCase(UserOutput userOutput) {
        this.userOutput = userOutput;
    }

    @Override
    public User execute(String email) {
        return userOutput.findByEmail(email);
    }
}
