package com.projetovenda.vendas.dto;

import com.projetovenda.vendas.model.UnidadeMedida;

import java.util.List;
import java.util.stream.Collectors;

public class UnidadeMedidaDTO {
    private int unidadeMedidaId;
    private String nome;

    // Constructor
    public UnidadeMedidaDTO(int unidadeMedidaId, String nome) {
        this.unidadeMedidaId = unidadeMedidaId;
        this.nome = nome;
    }

    public UnidadeMedidaDTO(UnidadeMedida unidadeMedida) {
        unidadeMedidaId = unidadeMedida.getUnidade_medida_id();
        nome = unidadeMedida.getNome();
    }

    // Getters
    public int getUnidadeMedidaId() {
        return unidadeMedidaId;
    }

    public String getNome() {
        return nome;
    }

    public static List<UnidadeMedidaDTO> converterToDTOList(List<UnidadeMedida> unidadesMedida) {
        return unidadesMedida.stream().map(UnidadeMedidaDTO::new).collect(Collectors.toList());
    }

    public UnidadeMedida createUnidadeMedida() {
        UnidadeMedida unidadeMedida = new UnidadeMedida();

        unidadeMedida.setNome(nome);
        return unidadeMedida;
    }

    public void updateUnidadeMedida(UnidadeMedida unidadeMedida) {
        unidadeMedida.setNome(nome);
    }
}
