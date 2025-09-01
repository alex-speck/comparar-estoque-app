package br.com.comparacaoestoque.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class MyPanel extends JFrame {

    private JButton btnArquivo1;
    private JButton btnArquivo2;
    private JButton btnComparar;
    private JTextArea txtResultado;
    private JFileChooser fileChooser;

    private File arquivo1;
    private File arquivo2;

    public MyPanel() {
        setTitle("Comparar Arquivos");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // centraliza a janela

        // Layout principal
        setLayout(new BorderLayout(10, 10));

        // Painel superior para botões de arquivos
        JPanel painelArquivos = new JPanel(new GridLayout(1, 2, 10, 10));

        btnArquivo1 = new JButton("Selecionar Arquivo 1");
        btnArquivo2 = new JButton("Selecionar Arquivo 2");

        painelArquivos.add(btnArquivo1);
        painelArquivos.add(btnArquivo2);

        // Botão de comparar centralizado
        JPanel painelComparar = new JPanel();
        btnComparar = new JButton("Comparar Arquivos");
        btnComparar.setEnabled(false); // começa desabilitado
        painelComparar.add(btnComparar);

        // Área de resultado (aumentei as dimensões)
        txtResultado = new JTextArea(15, 50);
        txtResultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtResultado);

        // File chooser
        fileChooser = new JFileChooser();

        // Ações dos botões
        btnArquivo1.addActionListener(this::selecionarArquivo1);
        btnArquivo2.addActionListener(this::selecionarArquivo2);

        // Adiciona tudo ao frame
        add(painelArquivos, BorderLayout.NORTH);
        add(painelComparar, BorderLayout.CENTER);
        add(scroll, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void selecionarArquivo1(ActionEvent e) {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            arquivo1 = fileChooser.getSelectedFile();
            txtResultado.append("Arquivo 1 selecionado: " + arquivo1.getAbsolutePath() + "\n");
            verificarArquivosSelecionados();
        }
    }

    private void selecionarArquivo2(ActionEvent e) {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            arquivo2 = fileChooser.getSelectedFile();
            txtResultado.append("Arquivo 2 selecionado: " + arquivo2.getAbsolutePath() + "\n");
            verificarArquivosSelecionados();
        }
    }

    private void verificarArquivosSelecionados() {
        btnComparar.setEnabled(arquivo1 != null && arquivo2 != null);
    }

}