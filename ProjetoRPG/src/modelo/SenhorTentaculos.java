package modelo;

public class SenhorTentaculos extends Monstro {
    public SenhorTentaculos() {
        super("Senhor Tentáculos", 100, 25, 5, "Abissal");
    }

    @Override
    public void ataqueFeroz(Personagem alvo) {
        System.out.println("O Senhor Tentáculos usa Chicote de Tinta!");
        alvo.receberDano(getAtaque() + 5);
    }
}