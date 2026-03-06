package modelo;

import java.io.Serializable;

public abstract class Personagem implements Serializable {
    private String nome;
    private int vida;
    private int ataque;
    private int defesa;

    public Personagem(String nome, int vida, int ataque, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public String getNome() { return nome; }
    public int getVida() { return vida; }
    public int getAtaque() { return ataque; }
    public int getDefesa() { return defesa; }

    public void receberDano(int dano) {
        int danoFinal = dano - defesa;
        if (danoFinal > 0) {
            this.vida -= danoFinal;
            if (this.vida < 0) this.vida = 0;
        }
    }

    public void curar(int quantidade) {
        this.vida += quantidade;
    }

    public boolean estaVivo() { return vida > 0; }
}