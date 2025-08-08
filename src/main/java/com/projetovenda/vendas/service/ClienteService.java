package com.projetovenda.vendas.service;

import com.projetovenda.vendas.exception.ClienteException;
import com.projetovenda.vendas.exception.ClienteNotFoundException;
import com.projetovenda.vendas.model.Cliente;
import com.projetovenda.vendas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente saveCliente(Cliente cliente){
        validateName(cliente.getNome());
        validateDateOfBirth(cliente.getDataNascimento());
/*        validateCPFExists(cliente.getCpf());*/
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
        if(clienteName.length() < 10) {
            throw new ClienteException("O nome não pode ter menos do que 20 caracteres");
        } else if (clienteName.length() > 255) {
            throw new ClienteException("O nome não pode ter mais do que 255 caracteres");
        }
    }

    private void validateDateOfBirth(LocalDate dataNascimento){
        if(dataNascimento == null) {
            throw new ClienteException("Data de nascimento é obrigatória");
        } else if (dataNascimento.isAfter(LocalDate.now())) {
            throw new ClienteException("Data de nascimento não pode ser no futuro");
        } else if (dataNascimento.isBefore(LocalDate.of(1900, 1, 1))) {
            throw new ClienteException("Data de nascimento não pode ser antes de 1900");
        }
    }

    /*private void validateCPFExists(String cpf){
        if (cpf != null) {
            throw new ClienteException("CPF já cadastrado");
        }
    }

    private Boolean validateScriptInjection(String email){
        String EMAIL_REGEX = "/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/";

        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }*/
}
