package br.com.matheuscalaca.gastosDiarios.core.useCase;

import br.com.matheuscalaca.gastosDiarios.core.domain.Gasto;
import br.com.matheuscalaca.gastosDiarios.core.domain.User;
import br.com.matheuscalaca.gastosDiarios.core.exception.ValidException;
import br.com.matheuscalaca.gastosDiarios.core.input.GetGastoUserByMonthInput;
import br.com.matheuscalaca.gastosDiarios.core.output.GastoOutput;

import java.time.LocalDate;
import java.util.List;

public class GetGastoUserByMonthUseCase implements GetGastoUserByMonthInput {

    private GastoOutput gastoOutput;

    public GetGastoUserByMonthUseCase(GastoOutput gastoOutput) {
        this.gastoOutput = gastoOutput;
    }

    public GetGastoUserByMonthUseCase() {
    }

    @Override
    public List<Gasto> execute(User user, Integer month, Integer year) {
        if (month == null || month > 12 || month < 1) {
            throw new ValidException("month Error month: " + month);
        }

        if (year == null || year > LocalDate.now().getYear()) {
            throw new ValidException("year Error year: " + year);
        }

        if (user == null) {
            throw new ValidException("User error");
        }

        return gastoOutput.findByUserAndMonth(user, month, year);
    }
}
