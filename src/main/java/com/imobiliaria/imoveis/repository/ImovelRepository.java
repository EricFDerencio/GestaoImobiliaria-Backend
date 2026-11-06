package com.imobiliaria.imoveis.repository;

import com.imobiliaria.imoveis.model.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;

/** Acesso ao banco. O Spring Data gera save(), findAll() etc. automaticamente. */
public interface ImovelRepository extends JpaRepository<Imovel, Long> {
}
