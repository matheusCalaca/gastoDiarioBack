package br.com.matheuscalaca.gastosDiarios.core.domain;

public enum Response {

    SUCCESS(0, "Success"),
    ERROR_VALIDATION(1, "Erro de Validação");

    private final int code;
    private final String message;

    Response(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
