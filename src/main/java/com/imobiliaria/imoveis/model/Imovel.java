package com.imobiliaria.imoveis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

/**
 * Entidade Imovel: serve ao mesmo tempo como tabela no banco
 * e como corpo (JSON) das requisições e respostas da API.
 */
@Entity
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "é obrigatória")
    private String descricao;

    @NotBlank(message = "é obrigatório")
    private String endereco;

    // O valor permitido (Casa, Apartamento, Terreno) é checado no ImovelService
    @NotBlank(message = "é obrigatório")
    private String tipo;

    @NotNull(message = "é obrigatório")
    @Positive(message = "deve ser maior que zero")
    private BigDecimal valor;

    @NotNull(message = "é obrigatório (true ou false)")
    private Boolean disponivel;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }

    public Boolean getDisponivel() { return disponivel; }
    public void setDisponivel(Boolean disponivel) { this.disponivel = disponivel; }
}
