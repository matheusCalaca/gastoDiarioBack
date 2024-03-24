package br.com.matheuscalaca.gastosDiarios.core.useCase;

import br.com.matheuscalaca.gastosDiarios.core.domain.Gasto;
import br.com.matheuscalaca.gastosDiarios.core.domain.ResumoGasto;
import br.com.matheuscalaca.gastosDiarios.core.domain.User;
import br.com.matheuscalaca.gastosDiarios.core.input.GetResumoGastoUserByMonthInput;
import br.com.matheuscalaca.gastosDiarios.core.output.GastoOutput;

import java.math.BigDecimal;
import java.util.List;

public class GetResumoGastoUserByMonthUseCase implements GetResumoGastoUserByMonthInput {

    private GastoOutput gastoOutput;

    public GetResumoGastoUserByMonthUseCase(GastoOutput gastoOutput) {
        this.gastoOutput = gastoOutput;
    }

    public GetResumoGastoUserByMonthUseCase() {
    }

    @Override
    public ResumoGasto execute(User user, Integer month, Integer year) {
        validMonthYearUser(user, month, year);

        List<Gasto> gastos = gastoOutput.findByUserAndMonth(user, month, year);
        BigDecimal sumGasto = gastos.stream().map(Gasto::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new ResumoGasto(sumGasto, BigDecimal.ZERO, BigDecimal.ZERO);
    }

    static void validMonthYearUser(User user, Integer month, Integer year) {
        GetGastoUserByMonthUseCase.validateMonthYearUser(user, month, year);
    }
}
