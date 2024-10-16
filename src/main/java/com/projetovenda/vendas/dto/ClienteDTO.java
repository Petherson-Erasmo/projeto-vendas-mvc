package com.projetovenda.vendas.dto;

import com.projetovenda.vendas.exception.ValidateFormFillingException;
import com.projetovenda.vendas.model.Cliente;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteDTO {
    private int id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;

    //Getters
    public int getIdCliente() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    // Constructor
    public ClienteDTO(int id, String nome, String cpf, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public ClienteDTO(Cliente cliente) {
        id = cliente.getIdCliente();
        nome = cliente.getNome();
        cpf = cliente.getCpf();
        dataNascimento = cliente.getDataNascimento();
    }

    public static List<ClienteDTO> converterToDTOList(List<Cliente> clientes) {
        return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }

    public Cliente createCliente() {
        Cliente cliente = new Cliente();

        validateCliente();
        cliente.setCpf(cpf);
        cliente.setNome(nome);
        cliente.setDataNascimento(dataNascimento);
        return cliente;
    }

    public void updateCliente(Cliente cliente) {
        validateCliente();

        cliente.setCpf(cpf);
        cliente.setNome(nome);
        cliente.setDataNascimento(dataNascimento);
    }

    private void validateCliente() {
        if (nome == null || nome.isBlank()){
            throw new ValidateFormFillingException("Nome Obrigatório");
        }else if (cpf == null || cpf.isBlank()) {
            throw new ValidateFormFillingException("CPF Obrigatório");
        } else if (cpf.length() != 11) {
            throw new ValidateFormFillingException("CPF deve ter 11 caracteres");
        } else if (dataNascimento == null) {
            throw new ValidateFormFillingException("Data de Nascimento Obrigatório");
        }
    }
}
