package modelo;

import java.io.Serializable;

public class Item implements Serializable {
    private String nome;
    private int bonusAtaque;

    public Item(String nome, int bonusAtaque) {
        this.nome = nome;
        this.bonusAtaque = bonusAtaque;
    }

    public String getNome() { return nome; }
    public int getBonusAtaque() { return bonusAtaque; }
}