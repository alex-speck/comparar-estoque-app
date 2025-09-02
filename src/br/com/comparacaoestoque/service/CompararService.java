package br.com.comparacaoestoque.service;

import br.com.comparacaoestoque.dto.ComparacaoResponseDTO;
import br.com.comparacaoestoque.model.Estoque;
import br.com.comparacaoestoque.model.Pedido;
import br.com.comparacaoestoque.model.PedidoItem;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompararService {

    public List<ComparacaoResponseDTO> compararPedidoEstoque(List<Pedido> pedidos, List<Estoque> estoqueItem) {
        List<ComparacaoResponseDTO> resultado = new ArrayList<>();

        // cria mapa de estoque disponível
        Map<BigInteger, Double> estoqueMap = new HashMap<>();
        for (Estoque e : estoqueItem) {
            estoqueMap.put(e.getCodigoItem(), e.getQuantidadeDisp());
        }

        // percorre os pedidos
        for (Pedido pedido : pedidos) {
            for (PedidoItem item : pedido.getPedidoItems()) {
                BigInteger codItem = item.getCodigoItem();
                double qtdPedido = item.getQuantidadeItem();

                double qtdEstoque = estoqueMap.getOrDefault(codItem, 0.0);

                ComparacaoResponseDTO dto = new ComparacaoResponseDTO();
                dto.setCodPedido(pedido.getCodigo());
                dto.setNomeCliente(pedido.getNome());
                dto.setCodItem(codItem);
                dto.setNomeItem(item.getNomeItem());
                dto.setQtdPedido(qtdPedido);
                dto.setQtdEstoque(qtdEstoque);

                if (qtdEstoque >= qtdPedido) {
                    // atende tudo
                    dto.setQtdAtendida(qtdPedido);
                    dto.setQtdFaltante(0);
                    dto.setEmEstoque(true);
                    estoqueMap.put(codItem, qtdEstoque - qtdPedido);
                } else {
                    // atende só o que tem
                    dto.setQtdAtendida(qtdEstoque);
                    dto.setQtdFaltante(qtdPedido - qtdEstoque);
                    dto.setEmEstoque(false);
                    estoqueMap.put(codItem, 0.0);
                }

                resultado.add(dto);
            }
        }

        return resultado;
    }

}
