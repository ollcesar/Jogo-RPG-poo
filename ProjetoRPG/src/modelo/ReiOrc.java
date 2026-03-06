package modelo;

public class ReiOrc extends Monstro {
    public ReiOrc() {
        super("Rei Orc", 150, 22, 12, "Chefe");
    }

    @Override
    public void ataqueFeroz(Personagem alvo) {
        alvo.receberDano(getAtaque() + 10);
    }
}