package com.projetovenda.vendas.controller;

import com.projetovenda.vendas.dto.UnidadeMedidaDTO;
import com.projetovenda.vendas.exception.ClienteException;
import com.projetovenda.vendas.exception.UnidadeMedidaNotFoundException;
import com.projetovenda.vendas.model.UnidadeMedida;
import com.projetovenda.vendas.service.UnidadeMedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unidades-medida")
public class UnidadeMedidaController {

    @Autowired
    public UnidadeMedidaService unidadeMedidaService;

    @GetMapping
    public ResponseEntity<List<UnidadeMedidaDTO>> getAllUnidadeMedida() {
        List<UnidadeMedida> unidadesMedida = unidadeMedidaService.findAllUnidadeMedida();
        return ResponseEntity.status(HttpStatus.OK).body(UnidadeMedidaDTO.converterToDTOList(unidadesMedida));
    }

    @PostMapping
    public ResponseEntity<UnidadeMedidaDTO> createUnidadeMedida(@RequestBody UnidadeMedidaDTO unidadeMedidaDTO) {
        UnidadeMedida unidadeMedida = unidadeMedidaDTO.createUnidadeMedida();

        UnidadeMedida newUnidadeMedida = unidadeMedidaService.saveUnidadeMedida(unidadeMedida);
        return ResponseEntity.status(HttpStatus.CREATED).body(new UnidadeMedidaDTO(newUnidadeMedida));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUnidadeMedida(@PathVariable Long id, @RequestBody UnidadeMedidaDTO unidadeMedidaDTO) {
        try {
            UnidadeMedida unidadeMedida = unidadeMedidaService.findUnidadeMedidaById(id);
            unidadeMedidaDTO.updateUnidadeMedida(unidadeMedida);
            UnidadeMedida updatedUnidadeMedida = unidadeMedidaService.saveUnidadeMedida(unidadeMedida);
            return ResponseEntity.status(HttpStatus.OK).body(new UnidadeMedidaDTO(updatedUnidadeMedida));
        } catch (ClienteException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUnidadeMedida(@PathVariable Long id) {
        try {
            unidadeMedidaService.deleteUnidadeMedida(id);
            return ResponseEntity.status(HttpStatus.OK).body("Unidade de medida deletada com sucesso");
        } catch (UnidadeMedidaNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
