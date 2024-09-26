package com.projetovenda.vendas.controller;

import com.projetovenda.vendas.exception.ClienteException;
import com.projetovenda.vendas.exception.ClienteNotFoundException;
import com.projetovenda.vendas.exception.ValidateFormFillingException;
import com.projetovenda.vendas.service.ClienteService;
import com.projetovenda.vendas.dto.ClienteDTO;
import com.projetovenda.vendas.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAllClientes() {
        List<Cliente> clientes = clienteService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(ClienteDTO.converterToDTOList(clientes));
    }

     @GetMapping("/{id}")
     public ResponseEntity getClienteById(@PathVariable Long id) {
         try {
             Cliente cliente = clienteService.findById(id);
             return ResponseEntity.status(HttpStatus.OK).body(new ClienteDTO(cliente));
         } catch (ClienteNotFoundException e) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
         } catch (RuntimeException e) {
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro Interno");
         }
     }

    @PostMapping
    public ResponseEntity saveCliente(@RequestBody ClienteDTO clienteDTO) {
        try {
            Cliente cliente = clienteDTO.createCliente();
            Cliente newCliente = clienteService.saveCliente(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ClienteDTO(newCliente));
        } catch (ValidateFormFillingException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (ClienteException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(e.getMessage());
        }

    }

    @PutMapping("/{id}")
     public ResponseEntity updateCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        try {
            Cliente cliente = clienteService.findById(id);
            clienteDTO.updateCliente(cliente);
            Cliente updateCliente = clienteService.saveCliente(cliente);
            return ResponseEntity.status(HttpStatus.OK).body(new ClienteDTO(updateCliente));
        } catch (ClienteNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro Interno");
        }
     }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCliente(@PathVariable Long id) {
        try {
            clienteService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Cliente Apagado");
        } catch (ClienteNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro Interno");
        }
    }

}