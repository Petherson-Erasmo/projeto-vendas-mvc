package com.projetovenda.vendas.dto;

import com.projetovenda.vendas.model.Produto;
import com.projetovenda.vendas.model.UnidadeMedida;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutoDTO {
    private int id;
    private String nome;
    private float valor;
    private int quantidade;
    private UnidadeMedida unidadeMedida;

    // Constructor
    public ProdutoDTO(int id, String nome, float valor, int quantidade, UnidadeMedida unidadeMedida) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.unidadeMedida = unidadeMedida;
    }

    public ProdutoDTO(Produto produto) {
        id = produto.getIdproduto();
        nome = produto.getNome();
        valor = produto.getValor();
        quantidade = produto.getQuantidade();
        unidadeMedida = produto.getUnidadeMedida();
    }

    // Getters
    public int getIdproduto() {
        return id;
    }
    public String getNome() {
        return nome;
    }

    public float getValor() {
        return valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public static List<ProdutoDTO> converterToDTOList(List<Produto> produtos) {
        return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
    }

    public Produto createProduto() {
        Produto produto = new Produto();

        produto.setNome(nome);
        produto.setValor(valor);
        produto.setQuantidade(quantidade);
        produto.setUnidadeMedida(unidadeMedida);
        return produto;
    }

    public void updateProduto(Produto produto) {
        produto.setNome(nome);
        produto.setValor(valor);
        produto.setQuantidade(quantidade);
    }
}
