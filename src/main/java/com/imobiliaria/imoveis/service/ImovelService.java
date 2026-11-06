package com.imobiliaria.imoveis.service;

import com.imobiliaria.imoveis.exception.DadosInvalidosException;
import com.imobiliaria.imoveis.model.Imovel;
import com.imobiliaria.imoveis.repository.ImovelRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/** Regras de negócio dos imóveis. */
@Service
public class ImovelService {

    private static final Set<String> TIPOS_PERMITIDOS = Set.of("Casa", "Apartamento", "Terreno");

    private final ImovelRepository repository;

    public ImovelService(ImovelRepository repository) {
        this.repository = repository;
    }

    public List<Imovel> listar() {
        return repository.findAll(Sort.by("id"));
    }

    public Imovel cadastrar(Imovel imovel) {
        if (imovel.getTipo() == null || !TIPOS_PERMITIDOS.contains(imovel.getTipo())) {
            throw new DadosInvalidosException("tipo: deve ser Casa, Apartamento ou Terreno");
        }
        // O id é sempre gerado pelo banco, mesmo que o cliente envie um
        imovel.setId(null);
        return repository.save(imovel);
    }
}
