package br.com.comparacaoestoque.app;

import br.com.comparacaoestoque.dto.ComparacaoResponseDTO;
import br.com.comparacaoestoque.model.Estoque;
import br.com.comparacaoestoque.model.Pedido;
import br.com.comparacaoestoque.service.CompararService;
import br.com.comparacaoestoque.service.EstoqueService;
import br.com.comparacaoestoque.service.PedidoService;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class TesteComparacao {

    public static void main(String[] args)  {

        PedidoService pedidoService = new PedidoService();
        EstoqueService estoqueService = new EstoqueService();

        String arqEstoque = "C:\\Users\\alexs\\Downloads\\Dados Estoque.xlsx";
        String arqPedido = "C:\\Users\\alexs\\Downloads\\Dados Pedidos.xlsx";

        List<Estoque> estoqueList = new ArrayList<>();
        try {
            estoqueList = estoqueService.lerArquivoEstoque(arqEstoque);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        List<Pedido> pedidoList = new ArrayList<>();
        try {
            pedidoList = pedidoService.lerArquivoPedido(arqPedido);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Service
        CompararService service = new CompararService();
        List<ComparacaoResponseDTO> resultado = service.compararPedidoEstoque(pedidoList, estoqueList);

        // Exibe o resultado
        resultado.forEach(System.out::println);
    }
}
