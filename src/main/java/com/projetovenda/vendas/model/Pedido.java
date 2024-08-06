package com.projetovenda.vendas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpedido;

    @Column(name = "valorTotal", nullable = false)
    private float valorTotal;

    @ManyToOne
    @JoinColumn(name = "cliente_idcliente", nullable = false)
    private Cliente cliente;

    // Getters
    public int getIdpedido() {
        return idpedido;
    }
    public float getValorTotal(){
        return valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    //Setters

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setCliente_id(Cliente cliente) {
        this.cliente = cliente;
    }
}
