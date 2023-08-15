package com.guiSuttanni.testeSpringH2.repositories;

import com.guiSuttanni.testeSpringH2.entities.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}
