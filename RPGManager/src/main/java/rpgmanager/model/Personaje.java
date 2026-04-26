package rpgmanager.model;

public abstract class Personaje {
    protected String nombre;
    protected int nivel, puntosVida, puntosVidaMax;

    public Personaje(String nombre, int nivel, int puntosVidaMax) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVidaMax = puntosVidaMax;
        this.puntosVida = puntosVidaMax;
    }

    public void recibirDano(int dano) {
        puntosVida = Math.max(0, puntosVida - dano);
        System.out.println(nombre + " recibe " + dano + " de daño. HP: " + puntosVida + "/" + puntosVidaMax);
    }

    public boolean estaVivo() {
        return puntosVida > 0;
    }

    public abstract void atacar(Personaje objetivo);
    public abstract String getTipoPersonaje();

    @Override
    public String toString() {
        return String.format("[%-7s] %-7s Nv.%d │ HP: %d/%d",
                getTipoPersonaje(), nombre, nivel, puntosVida, puntosVidaMax);
    }
}