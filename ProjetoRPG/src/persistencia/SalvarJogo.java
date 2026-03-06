package persistencia;

import modelo.Personagem;
import java.io.*;

public class SalvarJogo {
    public static void salvar(Personagem p, String arquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(p);
        }
    }

    public static Personagem carregar(String arquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (Personagem) ois.readObject();
        }
    }
}