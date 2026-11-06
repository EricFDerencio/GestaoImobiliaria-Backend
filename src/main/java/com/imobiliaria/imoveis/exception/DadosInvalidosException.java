package com.imobiliaria.imoveis.exception;

/** Lançada quando uma regra de negócio é violada (ex.: tipo de imóvel não permitido). */
public class DadosInvalidosException extends RuntimeException {

    public DadosInvalidosException(String mensagem) {
        super(mensagem);
    }
}
