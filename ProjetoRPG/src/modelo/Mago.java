package modelo;

public class Mago extends Personagem {
    private int mana;

    public Mago(String nome, int vida, int ataque, int defesa, int mana) {
        super(nome, vida, ataque, defesa);
        this.mana = mana;
    }

    public void lancarMagia(Personagem alvo) {
        if (mana >= 10) {
            alvo.receberDano(getAtaque() * 2);
            mana -= 10;
        }
    }
}