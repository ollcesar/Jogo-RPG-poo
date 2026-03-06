package modelo;

public class Fada extends Personagem {
    private int essencia;

    public Fada(String nome, int vida, int ataque, int defesa) {
        super(nome, vida, ataque, defesa);
        this.essencia = 30;
    }

    public void luzCura(Personagem alvo) {
        if (essencia >= 10) {
            this.receberDano(-20);
            System.out.println(getNome() + " usou Luz de Cura!");
            essencia -= 10;
        }
    }

    public int getEssencia() { return essencia; }
}