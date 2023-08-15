package com.guiSuttanni.testeSpringH2.modules.produto;

import com.guiSuttanni.testeSpringH2.entities.Produto;
import com.guiSuttanni.testeSpringH2.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;
    @PostMapping
    public Produto insert(@RequestBody Produto produto) {
        return repository.save(produto);
    }

    @GetMapping(value = "/{id}")
    public Produto findById(@PathVariable Long id) {
        return repository.findById(id).get();
    }
}
