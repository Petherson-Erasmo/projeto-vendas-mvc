package com.projetovenda.vendas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idproduto;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private int quantidade;

    @Column(nullable = false)
    private float valor;

    @ManyToOne
    @JoinColumn(name = "idunidade_medida", nullable = false)
    private UnidadeMedida unidadeMedida;

    // Getters
    public int getIdproduto() {
        return idproduto;
    }
    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public float getValor() {
        return valor;
    }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

}
