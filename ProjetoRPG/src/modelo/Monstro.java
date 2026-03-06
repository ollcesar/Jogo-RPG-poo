package modelo;

public class Monstro extends Personagem {
    private String tipo;

    public Monstro(String nome, int vida, int ataque, int defesa, String tipo) {
        super(nome, vida, ataque, defesa);
        this.tipo = tipo;
    }

    public void ataqueFeroz(Personagem alvo) {
        alvo.receberDano(getAtaque() + 5);
    }
}