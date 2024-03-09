package br.com.matheuscalaca.gastosDiarios.core.exception;

public class ValidException extends RuntimeException {

    public ValidException(String field){

        super("Compo invalido -> campo: "+field);
    }
}
