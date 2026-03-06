package modelo;

public class Guerreiro extends Personagem {
    private int furia;

    public Guerreiro(String nome, int vida, int ataque, int defesa) {
        super(nome, vida, ataque, defesa);
        this.furia = 0;
    }

    public void golpeEsmagador(Personagem alvo) {
        if (furia >= 20) {
            int danoExtra = getAtaque() + (furia / 2);
            System.out.println(getNome() + " usou GOLPE ESMAGADOR!");
            alvo.receberDano(danoExtra);
            furia = 0;
        } else {
            alvo.receberDano(getAtaque());
            furia += 10;
        }
    }
}