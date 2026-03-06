package visao;

import modelo.*; // Importa o Personagem, Guerreiro, Mago, Fada e a Exceção
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class TelaBatalha extends JFrame {
    private Personagem jogador;
    private Monstro inimigo;
    private JProgressBar barraJ, barraM;
    private JTextArea log;

    public TelaBatalha(Personagem jogador, Monstro inimigo) {
        this.jogador = jogador;
        this.inimigo = inimigo;

        configurarJanela();
        inicializarComponentes();
        
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void configurarJanela() {
        setTitle("Batalha Épica - POO UFU");
        setSize(650, 450);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        ((JPanel)getContentPane()).setBorder(new EmptyBorder(10, 10, 10, 10));
    }

    private void inicializarComponentes() {
        // Status Superior
        JPanel painelStatus = new JPanel(new GridLayout(1, 2, 20, 0));
        barraJ = new JProgressBar(0, jogador.getVida());
        barraJ.setValue(jogador.getVida());
        barraJ.setStringPainted(true);
        barraJ.setForeground(new Color(46, 204, 113));

        barraM = new JProgressBar(0, inimigo.getVida());
        barraM.setValue(inimigo.getVida());
        barraM.setStringPainted(true);
        barraM.setForeground(new Color(231, 76, 60));

        painelStatus.add(new JLabel(jogador.getNome() + " (Você)"));
        painelStatus.add(barraJ);
        painelStatus.add(new JLabel(inimigo.getNome() + " (Inimigo)"));
        painelStatus.add(barraM);

        // Log Central
        log = new JTextArea();
        log.setEditable(false);
        log.setBackground(Color.BLACK);
        log.setForeground(Color.WHITE);
        log.setFont(new Font("Consolas", Font.PLAIN, 13));

        // Botões Inferiores
        JPanel painelAcoes = new JPanel();
        JButton btnAtq = new JButton("Ataque Básico");
        JButton btnEsp = new JButton("Especial");

        btnAtq.addActionListener(e -> processarTurno(1));
        btnEsp.addActionListener(e -> processarTurno(2));

        painelAcoes.add(btnAtq);
        painelAcoes.add(btnEsp);

        add(painelStatus, BorderLayout.NORTH);
        add(new JScrollPane(log), BorderLayout.CENTER);
        add(painelAcoes, BorderLayout.SOUTH);
    }

    private void processarTurno(int tipo) {
        try {
            // Ação do Jogador
            if (tipo == 1) {
                inimigo.receberDano(jogador.getAtaque());
                log.append("> Você atacou com força!\n");
            } else {
                executarHabilidadeEspecial();
            }

            // Ação do Inimigo (se vivo)
            if (inimigo.estaVivo()) {
                inimigo.ataqueFeroz(jogador);
                log.append("> " + inimigo.getNome() + " revidou!\n");
            }

            atualizarInterface();
            checarFim();

        } catch (BatalhaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void executarHabilidadeEspecial() throws BatalhaException {
        if (jogador instanceof Guerreiro) {
            ((Guerreiro) jogador).golpeEsmagador(inimigo);
            log.append("> CRÍTICO! Golpe Esmagador!\n");
        } else if (jogador instanceof Mago) {
            ((Mago) jogador).lancarMagia(inimigo);
            log.append("> EXPLOSÃO! Magia arcana!\n");
        } else if (jogador instanceof Fada) {
            jogador.curar(20);
            log.append("> CURA! A fada recuperou HP!\n");
        }
    }

    private void atualizarInterface() {
        barraJ.setValue(jogador.getVida());
        barraM.setValue(inimigo.getVida());
        barraJ.setString(jogador.getVida() + " HP");
        barraM.setString(inimigo.getVida() + " HP");
    }

    private void checarFim() {
        if (!inimigo.estaVivo()) {
            JOptionPane.showMessageDialog(this, "Vitória! O monstro foi derrotado!");
            this.dispose();
        } else if (!jogador.estaVivo()) {
            JOptionPane.showMessageDialog(this, "Game Over! Você foi derrotado.");
            this.dispose();
        }
    }
}