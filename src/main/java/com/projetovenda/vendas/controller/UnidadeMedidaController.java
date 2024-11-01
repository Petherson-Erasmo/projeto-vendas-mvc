package com.projetovenda.vendas.controller;

import com.projetovenda.vendas.dto.UnidadeMedidaDTO;
import com.projetovenda.vendas.model.UnidadeMedida;
import com.projetovenda.vendas.repository.UnidadeMedidaRepository;
import org.apache.logging.log4j.util.Unbox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/unidades-medida")
public class UnidadeMedidaController {

    @Autowired
    private UnidadeMedidaRepository unidadeMedidaRepository;

    @GetMapping
    public List<UnidadeMedidaDTO> getAllUnidadeMedida() {
        List<UnidadeMedida> unidadesMedida = unidadeMedidaRepository.findAll();
        return UnidadeMedidaDTO.converterToDTOList(unidadesMedida);
    }

    @PostMapping
    public UnidadeMedidaDTO createUnidadeMedida(@RequestBody UnidadeMedidaDTO unidadeMedidaDTO) {
        UnidadeMedida unidadeMedida = unidadeMedidaDTO.createUnidadeMedida();

        unidadeMedidaRepository.save(unidadeMedida);
        return new UnidadeMedidaDTO(unidadeMedida);
    }

    @PutMapping("/{id}")
    public UnidadeMedidaDTO updateUnidadeMedida(@PathVariable Long id, @RequestBody UnidadeMedidaDTO unidadeMedidaDTO) {
        final Optional<UnidadeMedida> optUnidadeMedida = unidadeMedidaRepository.findById(id);

        if (optUnidadeMedida.isPresent()) {
            UnidadeMedida unidadeMedida = optUnidadeMedida.get();
            unidadeMedidaDTO.updateUnidadeMedida(unidadeMedida);
            unidadeMedidaRepository.save(unidadeMedida);
            return new UnidadeMedidaDTO(unidadeMedida);
        } else {
            System.out.println("Unidade de medida não encontrada");
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUnidadeMedida(@PathVariable Long id) {
        final Optional<UnidadeMedida> optUnidadeMedida = unidadeMedidaRepository.findById(id);

        if (optUnidadeMedida.isPresent()) {
            UnidadeMedida unidadeMedida = optUnidadeMedida.get();
            unidadeMedidaRepository.delete(unidadeMedida);
        } else {
            System.out.println("Unidade de medida não encontrada");
        }
    }
}
