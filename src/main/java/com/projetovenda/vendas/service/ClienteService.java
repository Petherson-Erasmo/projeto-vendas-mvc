package com.projetovenda.vendas.service;

import com.projetovenda.vendas.exception.ClienteException;
import com.projetovenda.vendas.exception.ClienteNotFoundException;
import com.projetovenda.vendas.model.Cliente;
import com.projetovenda.vendas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente saveCliente(Cliente cliente){
        validateName(cliente.getNome());
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById (Long id){
        Optional<Cliente> optCliente = clienteRepository.findById(id);
        if (optCliente.isPresent()) {
            return optCliente.get();
        } else {
            throw new ClienteNotFoundException("Cliente não encontrado");
        }
    }

    public void deleteById(Long id) {
        Cliente cliente = this.findById(id);
        if (cliente != null) {
            clienteRepository.deleteById(id);
        }
    }

    private void validateName(String clienteName){
        if(clienteName.length() < 20) {
            throw new ClienteException("O nome não pode ter menos do que 20 caracteres");
        } else if (clienteName.length() > 255) {
            throw new ClienteException("O nome não pode ter mais do que 255 caracteres");
        }
    }
}
