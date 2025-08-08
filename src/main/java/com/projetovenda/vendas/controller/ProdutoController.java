package com.projetovenda.vendas.controller;

import com.projetovenda.vendas.dto.ProdutoDTO;
import com.projetovenda.vendas.model.Produto;
import com.projetovenda.vendas.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<ProdutoDTO> getAllProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        return ProdutoDTO.converterToDTOList(produtos);
    }

    @GetMapping("/{id}")
    public ProdutoDTO getProdutoById(@PathVariable Long id) {
        final Optional<Produto> optProduto = produtoRepository.findById(id);

        if (optProduto.isPresent()) {
            Produto produto = optProduto.get();
            return new ProdutoDTO(produto);
        } else {
            System.out.println("Produto não encontrado");
            return null;
        }
    }

    @PostMapping
    public ProdutoDTO createProduto(@RequestBody ProdutoDTO produtoDTO) {
        Produto produto = produtoDTO.createProduto();

        produtoRepository.save(produto);
        return new ProdutoDTO(produto);
    }

    @PutMapping("/{id}")
    public ProdutoDTO updateProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        final Optional<Produto> optProduto = produtoRepository.findById(id);

        if (optProduto.isPresent()) {
            Produto produto = optProduto.get();
            produtoDTO.updateProduto(produto);
            produtoRepository.save(produto);
            return new ProdutoDTO(produto);
        } else {
            System.out.println("Produto não encontrado");
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteProduto(@PathVariable Long id) {
        final Optional<Produto> optProduto = produtoRepository.findById(id);

        if (optProduto.isPresent()) {
            produtoRepository.deleteById(id);
        } else {
            System.out.println("Produto não encontrado");
        }
    }

    @GetMapping("/all")
    public List<Produto> getAllProdutosasll() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos;
    }

}