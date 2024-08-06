package com.projetovenda.vendas.model;

import jakarta.persistence.*;

@Entity
@Table(name =  "unidade_medida")
public class UnidadeMedida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idunidade_medida;

    @Column(nullable = false, unique = true)
    private String nome;

    // Getter

    public int getUnidade_medida_id() {
        return idunidade_medida;
    }

    public String getNome() {
        return nome;
    }

    //setter
    public void setNome(String nome){
        this.nome = nome;
    }
}
