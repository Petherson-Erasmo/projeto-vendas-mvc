package com.projetovenda.vendas.service;

import com.projetovenda.vendas.exception.UnidadeMedidaNotFoundException;
import com.projetovenda.vendas.model.UnidadeMedida;
import com.projetovenda.vendas.repository.UnidadeMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadeMedidaService {
    @Autowired
    private UnidadeMedidaRepository unidadeMedidaRepository;

    public UnidadeMedida saveUnidadeMedida(UnidadeMedida unidadeMedida) {
        return unidadeMedidaRepository.save(unidadeMedida);
    }

    public List<UnidadeMedida> findAllUnidadeMedida() {
        return unidadeMedidaRepository.findAll();
    }

    public UnidadeMedida findUnidadeMedidaById(Long id) {
        Optional<UnidadeMedida> optUnidadeMedida = unidadeMedidaRepository.findById(id);
        if (optUnidadeMedida.isPresent()) {
            return optUnidadeMedida.get();
        } else {
            throw new UnidadeMedidaNotFoundException("Unidade de medida não encontrada");
        }
    }

    public void deleteUnidadeMedida(Long id) {
        UnidadeMedida unidadeMedida = this.findUnidadeMedidaById(id);
        if (unidadeMedida != null) {
            unidadeMedidaRepository.deleteById(id);
        } else {
            throw new UnidadeMedidaNotFoundException("Unidade de medida não encontrada");
        }
    }
}
