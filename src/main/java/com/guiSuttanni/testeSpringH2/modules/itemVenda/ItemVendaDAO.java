package com.guiSuttanni.testeSpringH2.modules.itemVenda;

import com.guiSuttanni.testeSpringH2.entities.ItemVenda;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ItemVendaDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<ItemVenda> findByVendaId(Long idVenda) {
        String query = "SELECT iv FROM ItemVenda iv WHERE iv.venda.idVenda = :idVenda";
        return entityManager.createQuery(query, ItemVenda.class)
                .setParameter("idVenda", idVenda)
                .getResultList();
    }
}
