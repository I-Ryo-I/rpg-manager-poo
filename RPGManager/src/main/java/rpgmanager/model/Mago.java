package rpgmanager.model;

import rpgmanager.interfaces.Habilidoso;
import rpgmanager.interfaces.Sanador;

public class Mago extends Personaje implements Habilidoso, Sanador {

    private int mana;
    private int manaMax;

    public Mago(String nombre, int nivel) {
        super(nombre, nivel, 60 + nivel * 5);
        this.manaMax = 80 + nivel * 10;
        this.mana = manaMax;
    }

    @Override
    public void atacar(Personaje objetivo) {
        if (mana >= 20) {
            int dano = 25 + nivel * 5;
            mana -= 20;
            System.out.println(nombre + " lanza un hechizo sobre " + objetivo.nombre + "! (Maná: " + mana + "/" + manaMax + ")");
            objetivo.recibirDano(dano);
        } else {
            System.out.println(nombre + " no tiene maná suficiente para atacar.");
        }
    }

    @Override
    public String getTipoPersonaje() { return "Mago"; }

    public void recuperarMana(int cantidad) {
        mana = Math.min(manaMax, mana + cantidad);
        System.out.println(nombre + " recupera " + cantidad + " de maná. Maná: " + mana + "/" + manaMax);
    }

    // --- Habilidoso ---
    @Override
    public void usarHabilidadEspecial(Personaje objetivo) {
        if (mana >= 20) {
            mana -= 20;
            System.out.println(nombre + " lanza ¡Bola de Fuego! sobre " + objetivo.nombre);
            objetivo.recibirDano(40);
        } else {
            System.out.println(nombre + " sin maná para Bola de Fuego.");
        }
    }

    @Override
    public int getCostoHabilidad() { return 20; }

    @Override
    public String getNombreHabilidad() { return "Bola de Fuego"; }

    // --- Sanador ---
    @Override
    public void sanar(Personaje objetivo) {
        int curado = Math.min(25, objetivo.puntosVidaMax - objetivo.puntosVida);
        objetivo.puntosVida += curado;
        System.out.println(nombre + " sana a " + objetivo.nombre + " por " + curado + " HP.");
    }

    @Override
    public int getPotenciaSanacion() { return 25; }
}