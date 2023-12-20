package views;

import javax.swing.*;
import java.awt.*;
import model.Tabuleiro;

public class PainelTabuleiro extends JPanel {

    private JLabel tempoLabel;
    private JLabel minasLabel;
    private JLabel emojiLabel;

    private boolean primeiroClique = true;

    public PainelTabuleiro(Tabuleiro tabuleiro) {
        setLayout(new BorderLayout());

        JPanel topoPanel = new JPanel(new BorderLayout());
        tempoLabel = new JLabel("Tempo: 0");
        minasLabel = new JLabel("Minas: " + tabuleiro.getMinas());
        emojiLabel = new JLabel("");

        topoPanel.add(tempoLabel, BorderLayout.WEST);
        topoPanel.add(emojiLabel, BorderLayout.CENTER);
        topoPanel.add(minasLabel, BorderLayout.EAST);

        add(topoPanel, BorderLayout.NORTH);

        setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));

        tabuleiro.paraCadaCampo(c -> add(new BotaoCampo(c)));
        tabuleiro.registrarObservador(e -> {
            SwingUtilities.invokeLater(() -> {
                if (e.isGanhou()) {
                    emojiLabel.setText("\uD83D\uDE03");
                    JOptionPane.showMessageDialog(this, "Ganhou :)");
                } else {
                    emojiLabel.setText("\uD83D\uDE41");
                    JOptionPane.showMessageDialog(this, "Perdeu :(");
                }

                tabuleiro.reiniciar();
            });
        });
    }

    public void atualizarTempo(int tempo) {
        tempoLabel.setText("Tempo: " + tempo);
    }

    public void atualizarMinas(int minas) {
        minasLabel.setText("Minas: " + minas);
    }

    public void primeiroCliqueRealizado() {
        primeiroClique = false;
    }

    public boolean isPrimeiroClique() {
        return primeiroClique;
    }
}

