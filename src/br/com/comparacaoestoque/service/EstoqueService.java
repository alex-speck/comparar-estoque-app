package br.com.comparacaoestoque.service;

import br.com.comparacaoestoque.model.Estoque;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class EstoqueService {

    public List<Estoque> lerCsvEstoque(String caminhoArquivo) {

        List<Estoque> estoqueList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))){

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] vetor = linha.split(",");
                BigInteger codigo = new BigInteger(vetor[0]);
                double qtd = Double.parseDouble(vetor[1].replace(",", "."));

                estoqueList.add(new Estoque(codigo, qtd));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return estoqueList;

    }

}
