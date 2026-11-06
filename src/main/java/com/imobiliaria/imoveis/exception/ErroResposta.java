package com.imobiliaria.imoveis.exception;

import java.util.List;

/**
 * Formato do JSON de erro devolvido pela API:
 * { "mensagem": "Dados inválidos", "detalhes": ["valor: deve ser maior que zero"] }
 */
public record ErroResposta(String mensagem, List<String> detalhes) {
}
