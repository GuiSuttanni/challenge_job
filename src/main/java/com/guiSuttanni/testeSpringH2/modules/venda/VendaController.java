package com.guiSuttanni.testeSpringH2.modules.venda;

import com.guiSuttanni.testeSpringH2.entities.ItemVenda;
import com.guiSuttanni.testeSpringH2.entities.Venda;
import com.guiSuttanni.testeSpringH2.modules.itemVenda.ItemVendaDAO;
import com.guiSuttanni.testeSpringH2.repositories.ItemVendaRepository;
import com.guiSuttanni.testeSpringH2.repositories.VendaRepository;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/venda")
public class VendaController {

    @Autowired
    private ItemVendaDAO itemVendaDAO;
    @Autowired
    private VendaRepository vendaRepository;
    @Autowired
    private ItemVendaRepository itemVendaRepository;
    private VendaService vendaService;

    @GetMapping(value = "/{id}")
    public String loadTotal(@PathVariable Long id) {
        try {
            Venda venda = vendaRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Venda not found."));
            List<ItemVenda> itemVenda = itemVendaDAO.findByVendaId(id);

            BigDecimal valorTotal = vendaService.calcularTotalVenda(itemVenda, venda.getCooperado(), "vista".contains(venda.getTipoVenda()), venda);

            return "Valor total da venda: R$" + valorTotal.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    @GetMapping(value = "/totalDoItem")
    public String totalDoItem(@RequestParam Long id) {
        try {
            ItemVenda itemVenda = itemVendaRepository.findById(id).orElseThrow(() -> new NoSuchElementException("ItemVenda not found."));

            BigDecimal valorItem = vendaService.calcularValorItem(itemVenda, itemVenda.getVenda().getCooperado(), "vista".contains(itemVenda.getVenda().getTipoVenda()), itemVenda.getVenda());

            return "Valor total do item: R$" + valorItem.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
