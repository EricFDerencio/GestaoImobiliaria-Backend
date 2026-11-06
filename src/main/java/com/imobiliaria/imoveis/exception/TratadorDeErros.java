package com.imobiliaria.imoveis.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/** Transforma os erros da API em respostas 400 com JSON claro. */
@RestControllerAdvice
public class TratadorDeErros {

    // Falha nas anotações @NotBlank, @NotNull, @Positive
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResposta> tratarValidacao(MethodArgumentNotValidException ex) {
        List<String> detalhes = ex.getBindingResult().getFieldErrors().stream()
                .map(erro -> erro.getField() + ": " + erro.getDefaultMessage())
                .sorted()
                .toList();
        return ResponseEntity.badRequest().body(new ErroResposta("Dados inválidos", detalhes));
    }

    // Regra de negócio (tipo não permitido)
    @ExceptionHandler(DadosInvalidosException.class)
    public ResponseEntity<ErroResposta> tratarRegraDeNegocio(DadosInvalidosException ex) {
        return ResponseEntity.badRequest()
                .body(new ErroResposta("Dados inválidos", List.of(ex.getMessage())));
    }

    // JSON mal formado ou com tipo errado (ex.: "valor": "abc")
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErroResposta> tratarJsonInvalido(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest().body(new ErroResposta(
                "Dados inválidos",
                List.of("O corpo da requisição não é um JSON válido ou possui campos com tipo incorreto")));
    }
}
