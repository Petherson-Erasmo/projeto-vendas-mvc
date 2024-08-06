package com.projetovenda.vendas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "produto_has_pedido")
public class ProdutoPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int idProdutoPedido;

    @ManyToOne
    @JoinColumn(name = "produto_idproduto", nullable = false)
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "pedido_idpedido", nullable = false)
    private Pedido pedido;

    @Column(nullable = false)
    private int quantidade;

    // Getters
    public int getIdProdutoPedido() {
        return idProdutoPedido;
    }
    public Produto getProduto() {
        return produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    // Setters
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
