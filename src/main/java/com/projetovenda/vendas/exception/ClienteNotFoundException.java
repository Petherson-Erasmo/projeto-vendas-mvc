package com.projetovenda.vendas.exception;

public class ClienteNotFoundException extends RuntimeException {
    public ClienteNotFoundException(String msg) {
        super(msg);
    }

}
