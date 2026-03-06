package visao;

import modelo.*;
import javax.swing.*;
import java.awt.*;

public class TelaSelecao extends JFrame {
    private Personagem heroi;

    public TelaSelecao() {
        setTitle("RPG UFU - Seleção de Personagem");
        setSize(500, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1, 10, 10));

        JLabel titulo = new JLabel("Escolha seu Herói e depois o Inimigo", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));

        // Painel de Heróis
        JPanel herois = new JPanel();
        JButton btnG = new JButton("Guerreiro (Forte)");
        JButton btnM = new JButton("Mago (Explosivo)");
        JButton btnF = new JButton("Fada (Resistente)");

        // Painel de Monstros
        JPanel monstros = new JPanel();
        JButton btnOrc = new JButton("Rei Orc (Tanque)");
        JButton btnTent = new JButton("Sr. Tentáculos (Dano)");
        btnOrc.setEnabled(false);
        btnTent.setEnabled(false);

        // Lógica de Seleção de Atributos para o Equilíbrio
        btnG.addActionListener(e -> { 
            heroi = new Guerreiro("Guts", 180, 35, 18); // Vence ambos pelo HP alto
            ativarMonstros(btnOrc, btnTent);
        });

        btnM.addActionListener(e -> { 
            heroi = new Mago("Vivian", 85, 50, 5, 60); // Vence Tentáculos (burst), perde para Orc (HP baixo)
            ativarMonstros(btnOrc, btnTent);
        });

        btnF.addActionListener(e -> { 
            heroi = new Fada("Tinker", 120, 20, 12); // Vence Orc (cura), perde para Tentáculos (dano rápido)
            ativarMonstros(btnOrc, btnTent);
        });

        btnOrc.addActionListener(e -> iniciarBatalha(new ReiOrc()));
        btnTent.addActionListener(e -> iniciarBatalha(new SenhorTentaculos()));

        herois.add(btnG); herois.add(btnM); herois.add(btnF);
        monstros.add(btnOrc); monstros.add(btnTent);

        add(titulo); add(herois); add(monstros);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void ativarMonstros(JButton b1, JButton b2) {
        b1.setEnabled(true);
        b2.setEnabled(true);
    }

    private void iniciarBatalha(Monstro m) {
        new TelaBatalha(heroi, m);
        this.dispose();
    }
}