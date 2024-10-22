package com.projetovenda.vendas.dto;

import com.projetovenda.vendas.model.Produto;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutoDTO {
    private int id;
    private String nome;
    private float valor;
    private int quantidade;

    // Constructor
    public ProdutoDTO(String nome, float valor, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public ProdutoDTO(Produto produto) {
        id = produto.getIdproduto();
        nome = produto.getNome();
        valor = produto.getValor();
        quantidade = produto.getQuantidade();
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

    public static List<ProdutoDTO> converterToDTOList(List<Produto> produtos) {
        return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
    }

    public Produto createProduto() {
        Produto produto = new Produto();

        produto.setNome(nome);
        produto.setValor(valor);
        produto.setQuantidade(quantidade);
        return produto;
    }

    public void updateProduto(Produto produto) {
        produto.setNome(nome);
        produto.setValor(valor);
        produto.setQuantidade(quantidade);
    }
}