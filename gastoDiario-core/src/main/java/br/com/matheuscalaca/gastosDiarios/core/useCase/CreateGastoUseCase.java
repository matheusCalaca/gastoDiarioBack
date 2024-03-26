package br.com.matheuscalaca.gastosDiarios.core.useCase;

import br.com.matheuscalaca.gastosDiarios.core.domain.Gasto;
import br.com.matheuscalaca.gastosDiarios.core.exception.ValidException;
import br.com.matheuscalaca.gastosDiarios.core.input.CreateGastoInput;
import br.com.matheuscalaca.gastosDiarios.core.output.GastoOutput;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreateGastoUseCase implements CreateGastoInput {

    private GastoOutput gastoOutput;
    public CreateGastoUseCase(GastoOutput gastoOutput) {
        this.gastoOutput = gastoOutput;
    }

    @Override
    public Gasto execute(Gasto gasto) {
        if(gasto.getNome() == null || gasto.getNome().isBlank()){
            throw new ValidException("GASTO nome invalido: "+gasto.getNome());
        }

        if(gasto.getValor() == null || gasto.getValor().compareTo(BigDecimal.ZERO) <= 0 ){
            throw new ValidException("GASTO Valor invalido: "+gasto.getValor());
        }

        if(gasto.getData() == null || gasto.getData().isAfter(LocalDate.now())  ){
            throw new ValidException("GASTO Data Compra invalido: "+gasto.getData());
        }

        if(gasto.getCategoria() == null ){
            throw new ValidException("GASTO Categoria invalido: "+gasto.getCategoria());
        }

        gastoOutput.creat(gasto);

        return null;
    }
}
