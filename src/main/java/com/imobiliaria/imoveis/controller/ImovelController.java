package com.imobiliaria.imoveis.controller;

import com.imobiliaria.imoveis.model.Imovel;
import com.imobiliaria.imoveis.service.ImovelService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** Endpoints REST: GET e POST em /api/imoveis. */
@RestController
@RequestMapping("/api/imoveis")
public class ImovelController {

    private final ImovelService service;

    public ImovelController(ImovelService service) {
        this.service = service;
    }

    @GetMapping
    public List<Imovel> listar() {
        return service.listar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Imovel cadastrar(@Valid @RequestBody Imovel imovel) {
        return service.cadastrar(imovel);
    }
}
