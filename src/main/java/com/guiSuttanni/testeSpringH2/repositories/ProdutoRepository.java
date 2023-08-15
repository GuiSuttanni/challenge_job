package com.guiSuttanni.testeSpringH2.repositories;

import com.guiSuttanni.testeSpringH2.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}


