package com.guiSuttanni.testeSpringH2.modules.venda;

import com.guiSuttanni.testeSpringH2.entities.ItemVenda;
import com.guiSuttanni.testeSpringH2.entities.Cooperado;
import com.guiSuttanni.testeSpringH2.entities.Venda;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
public class VendaService {

        // Definir os percentuais de desconto por grupo de produtos
        private static final double[] DESCONTOS_POR_GRUPO = {0.01, 0.02, 0.03, 0.04, 0.05};

        // Definir os percentuais de desconto para Cooperados conceito A e B
        private static final double DESCONTO_COOPERADO_A = 0.05;
        private static final double DESCONTO_COOPERADO_B = 0.03;

        // Definir a taxa de juros para vendas a prazo (0.05% ao dia)
        private static final double TAXA_JUROS_AO_DIA = 0.0005;

        // Método para calcular o valor total da venda
        public static BigDecimal calcularTotalVenda(List<ItemVenda> itensVenda, Cooperado cooperado, boolean isVendaAVista, Venda venda) {
            try {
                if (itensVenda == null || cooperado == null || venda == null) {
                    throw new IllegalArgumentException("Os parâmetros itensVenda, cooperado e venda não podem ser nulos.");
                }

                BigDecimal valorTotal = BigDecimal.ZERO;

                for (ItemVenda item : itensVenda) {
                    if (item == null) {
                        throw new IllegalArgumentException("A lista de itens de venda não pode conter valores nulos.");
                    }

                    if (item.getValorUnitario() == null) {
                        throw new IllegalArgumentException("O valor unitário de um item de venda não pode ser nulo.");
                    }

                    int grupoProdutoId = Math.toIntExact(item.getProduto().getGrupoProduto().getIdGrupoProduto());
                    if (grupoProdutoId < 1 || grupoProdutoId > DESCONTOS_POR_GRUPO.length) {
                        throw new IllegalArgumentException("O ID do grupo de produto é inválido.");
                    }

                    double descontoProgressivo = DESCONTOS_POR_GRUPO[grupoProdutoId - 1];
                    BigDecimal valorItemComDesconto = item.getValorUnitario().multiply(BigDecimal.ONE.subtract(BigDecimal.valueOf(descontoProgressivo)));
                    valorTotal = valorTotal.add(valorItemComDesconto.multiply(BigDecimal.valueOf(item.getQuantidade())));
                }

                // Aplicar desconto adicional para Cooperados A e B em vendas à vista
                if (isVendaAVista) {
                    if ("A".equals(cooperado.getConceito())) {
                        BigDecimal descontoCooperadoA = valorTotal.multiply(BigDecimal.valueOf(DESCONTO_COOPERADO_A));
                        valorTotal = valorTotal.subtract(descontoCooperadoA);
                    } else if ("B".equals(cooperado.getConceito())) {
                        BigDecimal descontoCooperadoB = valorTotal.multiply(BigDecimal.valueOf(DESCONTO_COOPERADO_B));
                        valorTotal = valorTotal.subtract(descontoCooperadoB);
                    }
                } else {
                    // Calcular os juros para vendas a prazo
                    Date dataVenda = venda.getDataVenda();
                    Date dataVencimento = venda.getDataVencimento();
                    int dias = calcularDiasUteisEntreDatas(dataVenda, dataVencimento);
                    BigDecimal jurosVenda = calcularJurosVenda(valorTotal, dias);
                    valorTotal = valorTotal.add(jurosVenda);
                }

                return valorTotal;
            } catch (Exception e) {
                return null;
            }
        }

        public static BigDecimal calcularValorItem(ItemVenda itemVenda, Cooperado cooperado, boolean isVendaAVista, Venda venda) {
            try {
                if (itemVenda == null || cooperado == null || venda == null) {
                    throw new IllegalArgumentException("Os parâmetros itemVenda, cooperado e venda não podem ser nulos.");
                }

                BigDecimal valorTotal = BigDecimal.ZERO;

                BigDecimal valorItemComDesconto = itemVenda.getValorUnitario();
                if (valorItemComDesconto == null) {
                    throw new IllegalArgumentException("O valor unitário do item de venda não pode ser nulo.");
                }

                BigDecimal quantidade = BigDecimal.valueOf(itemVenda.getQuantidade());
                if (quantidade == null) {
                    throw new IllegalArgumentException("A quantidade do item de venda não pode ser nula.");
                }

                valorTotal = valorTotal.add(valorItemComDesconto.multiply(quantidade));

                // Aplicar desconto adicional para Cooperados A e B em vendas à vista
                if (isVendaAVista) {
                    if ("A".equals(cooperado.getConceito())) {
                        BigDecimal descontoCooperadoA = valorTotal.multiply(BigDecimal.valueOf(DESCONTO_COOPERADO_A));
                        valorTotal = valorTotal.subtract(descontoCooperadoA);
                    } else if ("B".equals(cooperado.getConceito())) {
                        BigDecimal descontoCooperadoB = valorTotal.multiply(BigDecimal.valueOf(DESCONTO_COOPERADO_B));
                        valorTotal = valorTotal.subtract(descontoCooperadoB);
                    }
                } else {
                    // Calcular os juros para vendas a prazo
                    Date dataVenda = venda.getDataVenda();
                    Date dataVencimento = venda.getDataVencimento();
                    int dias = calcularDiasUteisEntreDatas(dataVenda, dataVencimento);
                    BigDecimal jurosVenda = calcularJurosVenda(valorTotal, dias);
                    valorTotal = valorTotal.add(jurosVenda);
                }

                return valorTotal;
            } catch (Exception e) {
                return null;
            }
        }

        private static int calcularDiasUteisEntreDatas(Date dataInicial, Date dataFinal) {
            Calendar calInicial = Calendar.getInstance();
            calInicial.setTime(dataInicial);
            Calendar calFinal = Calendar.getInstance();
            calFinal.setTime(dataFinal);

            int diasUteis = 0;
            while (!calInicial.after(calFinal)) {
                int diaDaSemana = calInicial.get(Calendar.DAY_OF_WEEK);
                if (diaDaSemana != Calendar.SATURDAY && diaDaSemana != Calendar.SUNDAY) {
                    diasUteis++;
                }
                calInicial.add(Calendar.DAY_OF_MONTH, 1);
            }
            return diasUteis;
        }

        // Método para calcular o valor dos juros para vendas a prazo
        public static BigDecimal calcularJurosVenda(BigDecimal valorPrincipal, int dias) {
            BigDecimal taxaJuros = BigDecimal.valueOf(TAXA_JUROS_AO_DIA);
            BigDecimal valorJuros = valorPrincipal.multiply(BigDecimal.valueOf(Math.pow(1 + taxaJuros.doubleValue(), dias) - 1));
            return valorJuros;
        }
}

