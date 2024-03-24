package br.com.matheuscalaca.gastosDiarios.core.domain;

import java.math.BigDecimal;

public class ResumoGasto {
    private BigDecimal gastos;
    private BigDecimal ganhos;
    private BigDecimal saldo;

    public ResumoGasto(BigDecimal gastos, BigDecimal ganhos, BigDecimal saldo) {
        this.gastos = gastos;
        this.ganhos = ganhos;
        this.saldo = saldo;
    }

    public ResumoGasto() {
    }

    public BigDecimal getGastos() {
        return gastos;
    }

    public void setGastos(BigDecimal gastos) {
        this.gastos = gastos;
    }

    public BigDecimal getGanhos() {
        return ganhos;
    }

    public void setGanhos(BigDecimal ganhos) {
        this.ganhos = ganhos;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
