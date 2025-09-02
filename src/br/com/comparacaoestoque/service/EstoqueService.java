package br.com.comparacaoestoque.service;

import br.com.comparacaoestoque.model.Estoque;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class EstoqueService {

    private static String getCellValue(Row row, int cellIndex, DataFormatter formatter) {
        Cell cell = row.getCell(cellIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
        return formatter.formatCellValue(cell).trim();
    }

    public List<Estoque> lerArquivoEstoque(String arquivo) throws FileNotFoundException {

        List<Estoque> estoqueList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(new File(arquivo));
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            DataFormatter formatter = new DataFormatter();

            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row == null) continue;

                BigInteger codigo = new BigInteger(getCellValue(row, 0, formatter));
                double quantidade = Double.parseDouble(getCellValue(row, 1, formatter).replace(",","."));
                Estoque estoque = new Estoque(codigo, quantidade);

                estoqueList.add(estoque);

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return estoqueList;
    }

}
