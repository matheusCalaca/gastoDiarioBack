package br.com.matheuscalaca.gastosDiarios.core.useCase;

import br.com.matheuscalaca.gastosDiarios.core.domain.Ganho;
import br.com.matheuscalaca.gastosDiarios.core.domain.Gasto;
import br.com.matheuscalaca.gastosDiarios.core.domain.User;
import br.com.matheuscalaca.gastosDiarios.core.exception.ValidException;
import br.com.matheuscalaca.gastosDiarios.core.input.GetGanhoUserByMonthInput;
import br.com.matheuscalaca.gastosDiarios.core.input.GetGastoUserByMonthInput;
import br.com.matheuscalaca.gastosDiarios.core.output.GanhoOutput;
import br.com.matheuscalaca.gastosDiarios.core.output.GastoOutput;

import java.time.LocalDate;
import java.util.List;

public class GetGanhoUserByMonthUseCase implements GetGanhoUserByMonthInput {

    private GanhoOutput ganhoOutput;

    public GetGanhoUserByMonthUseCase(GanhoOutput ganhoOutput) {
        this.ganhoOutput = ganhoOutput;
    }

    public GetGanhoUserByMonthUseCase() {
    }

    @Override
    public List<Ganho> execute(User user, Integer month, Integer year) {
        validateMonthYearUser(user, month, year);

        return ganhoOutput.findByUserAndMonth(user, month, year);
    }

    static void validateMonthYearUser(User user, Integer month, Integer year) {
        if (month == null || month > 12 || month < 1) {
            throw new ValidException("month Error month: " + month);
        }

        if (year == null || year > LocalDate.now().getYear()) {
            throw new ValidException("year Error year: " + year);
        }

        if (user == null) {
            throw new ValidException("User error");
        }
    }
}
