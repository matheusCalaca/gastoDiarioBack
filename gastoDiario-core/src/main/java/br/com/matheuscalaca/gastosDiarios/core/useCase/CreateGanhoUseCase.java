package br.com.matheuscalaca.gastosDiarios.core.useCase;

import br.com.matheuscalaca.gastosDiarios.core.domain.Ganho;
import br.com.matheuscalaca.gastosDiarios.core.exception.ValidException;
import br.com.matheuscalaca.gastosDiarios.core.input.CreateGanhoInput;
import br.com.matheuscalaca.gastosDiarios.core.output.GanhoOutput;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreateGanhoUseCase implements CreateGanhoInput {

    private GanhoOutput ganhoOutput;

    public CreateGanhoUseCase(GanhoOutput ganhoOutput) {
        this.ganhoOutput = ganhoOutput;
    }

    @Override
    public Ganho execute(Ganho ganho) {
        if (ganho.getUser() == null) {
            throw new ValidException("GANHO user invalido: " + ganho.getUser());
        }

        if (ganho.getValor() == null || ganho.getValor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidException("GANHO Valor invalido: " + ganho.getValor());
        }

        if (ganho.getData() == null || ganho.getData().isAfter(LocalDate.now())) {
            throw new ValidException("GANHO Data invalido: " + ganho.getData());
        }

        if (ganho.getCategoria() == null) {
            throw new ValidException("GANHO Categoria invalido: " + ganho.getCategoria());
        }

        ganhoOutput.creat(ganho);
        return null;
    }
}
