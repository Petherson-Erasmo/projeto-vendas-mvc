package com.projetovenda.vendas.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private int id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false, name = "dataNascimento")
    private LocalDate dataNascimento;

    //Getters
    public int getIdCliente() {
        return id;
    }
    public String getNome(){
        return nome;
    }

    public String getCpf(){
        return cpf;
    }

    public LocalDate getDataNascimento(){
        return dataNascimento;
    }

    //Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
