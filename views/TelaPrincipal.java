package views;

import javax.swing.*;
import java.awt.event.*;

import model.Tabuleiro;

public class TelaPrincipal extends JFrame {

    TelaPrincipal(){
        setTitle("Campo Minado");
        setSize(1000, 645);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        JPanel painelSelecao = new JPanel();
        JLabel label = new JLabel("Escolha o nível:");
        
        // Botões de seleção de nível
        JButton nivelIniciante = new JButton("Iniciante");
        nivelIniciante.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                iniciarJogo(9, 9, 10);
            }
        });
        
        JButton nivelIntermediario = new JButton("Intermediário");
        nivelIntermediario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                iniciarJogo(16, 16, 40);
            }
        });
        
        JButton nivelAvancado = new JButton("Avançado");
        nivelAvancado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                iniciarJogo(24, 24, 99);
            }
        });
        
        painelSelecao.add(label);
        painelSelecao.add(nivelIniciante);
        painelSelecao.add(nivelIntermediario);
        painelSelecao.add(nivelAvancado);
        
        add(painelSelecao);
        setVisible(true);
    }
    
    private void iniciarJogo(int linhas, int colunas, int minas) {
        Tabuleiro tabuleiro = new Tabuleiro(linhas, colunas, minas);
        PainelTabuleiro painelTabuleiro = new PainelTabuleiro(tabuleiro);
        getContentPane().removeAll(); // Remove o painel de seleção
        add(painelTabuleiro);
        revalidate(); // Atualiza o conteúdo do JFrame
    }
    
    public static void main(String[] args) {
        new TelaPrincipal();
    }
}

