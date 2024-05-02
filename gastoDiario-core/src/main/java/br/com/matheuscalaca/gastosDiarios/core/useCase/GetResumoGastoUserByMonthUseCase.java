package br.com.matheuscalaca.gastosDiarios.core.useCase;

import br.com.matheuscalaca.gastosDiarios.core.domain.Ganho;
import br.com.matheuscalaca.gastosDiarios.core.domain.Gasto;
import br.com.matheuscalaca.gastosDiarios.core.domain.ResumoGasto;
import br.com.matheuscalaca.gastosDiarios.core.domain.User;
import br.com.matheuscalaca.gastosDiarios.core.input.GetResumoGastoUserByMonthInput;
import br.com.matheuscalaca.gastosDiarios.core.output.GanhoOutput;
import br.com.matheuscalaca.gastosDiarios.core.output.GastoOutput;

import java.math.BigDecimal;
import java.util.List;

public class GetResumoGastoUserByMonthUseCase implements GetResumoGastoUserByMonthInput {

    private GastoOutput gastoOutput;

    private GanhoOutput ganhoOutput;

    public GetResumoGastoUserByMonthUseCase(GastoOutput gastoOutput, GanhoOutput ganhoOutput) {
        this.gastoOutput = gastoOutput;
        this.ganhoOutput = ganhoOutput;
    }

    public GetResumoGastoUserByMonthUseCase() {
    }

    @Override
    public ResumoGasto execute(User user, Integer month, Integer year) {
        validMonthYearUser(user, month, year);

        BigDecimal sumGasto = recuperarGatos(user, month, year);

        BigDecimal sumGanho = recuperarGanhos(user, month, year);

        return new ResumoGasto(sumGasto, sumGanho, sumGanho.add(sumGasto));
    }

    private BigDecimal recuperarGanhos(User user, Integer month, Integer year) {
        List<Ganho> ganhos = ganhoOutput.findByUserAndMonth(user, month, year);

        return ganhos.stream().map(Ganho::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add).multiply(new BigDecimal("1"));
    }

    private BigDecimal recuperarGatos(User user, Integer month, Integer year) {
        List<Gasto> gastos = gastoOutput.findByUserAndMonth(user, month, year);
        return gastos.stream().map(Gasto::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add).multiply(new BigDecimal("-1"));
    }

    static void validMonthYearUser(User user, Integer month, Integer year) {
        GetGastoUserByMonthUseCase.validateMonthYearUser(user, month, year);
    }
}
