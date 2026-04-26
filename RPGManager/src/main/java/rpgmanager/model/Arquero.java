package rpgmanager.model;

public class Arquero extends Personaje {
    private int flechas;
    private int alcance;

    public Arquero(String nombre, int nivel) {
        super(nombre, nivel, 75 + nivel * 7);
        this.flechas = 10 + nivel * 2;
        this.alcance = 30;
    }

    @Override
    public void atacar(Personaje objetivo) {
        if (flechas > 0) {
            int dano = 12 + nivel * 4;
            flechas--;
            System.out.println(nombre + " dispara una flecha a " + objetivo.nombre + "! (Flechas restantes: " + flechas + ")");
            objetivo.recibirDano(dano);
        } else {
            System.out.println(nombre + " no tiene flechas.");
        }
    }

    @Override
    public String getTipoPersonaje() { return "Arquero"; }

    public void recargarFlechas(int cantidad) {
        flechas += cantidad;
        System.out.println(nombre + " recarga " + cantidad + " flechas. Total: " + flechas);
    }

    public int getFlechas() { return flechas; }
}
