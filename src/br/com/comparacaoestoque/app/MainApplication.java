package br.com.comparacaoestoque.app;

import br.com.comparacaoestoque.view.MyPanel;

import javax.swing.*;

public class MainApplication {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MyPanel::new);
    }
}
