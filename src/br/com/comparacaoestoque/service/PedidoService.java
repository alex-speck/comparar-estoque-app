package br.com.comparacaoestoque.service;

import br.com.comparacaoestoque.model.Pedido;
import br.com.comparacaoestoque.model.PedidoItem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PedidoService {

    private static String getCellValue(Row row, int cellIndex, DataFormatter formatter) {
        Cell cell = row.getCell(cellIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
        return formatter.formatCellValue(cell).trim();
    }

    public List<Pedido> lerArquivoPedido(String arquivo) throws FileNotFoundException {
        Map<BigInteger, Pedido> pedidoMap = new HashMap<>();

        try (FileInputStream fis = new FileInputStream(new File(arquivo));
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            DataFormatter formatter = new DataFormatter();

            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row == null) continue;

                BigInteger codigoPedido = new BigInteger(getCellValue(row, 2, formatter));
                String nomeCliente = getCellValue(row, 19, formatter);

                BigInteger codigoProduto = new BigInteger(getCellValue(row, 5, formatter));
                double qtdItem = Double.parseDouble(getCellValue(row, 6, formatter).replace(",", "."));
                String nomeItem = getCellValue(row, 30, formatter);

                PedidoItem item = new PedidoItem(codigoProduto, qtdItem, nomeItem);

                Pedido pedido = pedidoMap.get(codigoPedido);
                if (pedido == null) {
                    pedido = new Pedido(codigoPedido, nomeCliente, new ArrayList<>());
                    pedidoMap.put(codigoPedido, pedido);
                }

                pedido.getPedidoItems().add(item);

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return new ArrayList<>(pedidoMap.values());
    }


}
