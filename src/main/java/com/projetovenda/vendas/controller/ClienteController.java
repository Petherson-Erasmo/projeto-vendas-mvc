package com.projetovenda.vendas.controller;

import com.projetovenda.vendas.dto.ClienteDTO;
import com.projetovenda.vendas.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import com.projetovenda.vendas.repository.ClienteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<ClienteDTO> getAllClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return ClienteDTO.converterToDTOList(clientes);
    }

     @GetMapping("/{id}")
     public ClienteDTO getClienteById(@PathVariable Long id) {
         final Optional<Cliente> optCliente = clienteRepository.findById(id);

         if (optCliente.isPresent()) {
             Cliente cliente = optCliente.get();

             return new ClienteDTO(cliente);
         } else {
             System.out.println("Cliente não encontrado");
             return null;
         }
     }

    @PostMapping
    public ClienteDTO saveCliente(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = clienteDTO.createCliente();

        clienteRepository.save(cliente);
        return new ClienteDTO(cliente);
    }

    @PutMapping("/{id}")
     public ClienteDTO updateCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {

        final Optional<Cliente> optCliente = clienteRepository.findById(id);

        if (optCliente.isPresent()) {
            Cliente cliente = optCliente.get();
            clienteDTO.updateCliente(cliente);
            clienteRepository.save(cliente);
            return new ClienteDTO(cliente);
        } else {
            System.out.println("Cliente não encontrado");
            return null;
        }
     }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {

        final Optional<Cliente> optCliente = clienteRepository.findById(id);

        if (optCliente.isPresent()) {
            clienteRepository.deleteById(id);
        }else {
            System.out.println("Cliente não encontrado");
        }
    }

}