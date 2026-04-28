package rpgmanager.model;

import java.util.ArrayList;
import rpgmanager.interfaces.Habilidoso;
import rpgmanager.interfaces.Sanador;

public class BatallaCompleta {

    public static void main(String[] args) {

        System.out.println("=== Fase 1: Equipando personajes ===");
        Guerrero thorin  = new Guerrero("Thorin", 3);
        Mago gandalf     = new Mago("Gandalf", 5);
        Arquero legolas  = new Arquero("Legolas", 4);

        thorin.equiparItem("Espada Legendaria");
        legolas.equiparItem("Arco Élfico");

        ArrayList<Personaje> heroes = new ArrayList<>();
        heroes.add(thorin);
        heroes.add(gandalf);
        heroes.add(legolas);

        Personaje orco = new Guerrero("Orco", 1);

        System.out.println("\n=== Fase 2: Batalla ===");
        int turno = 1;

        while (orco.estaVivo()) {
            System.out.println("\n--- Turno " + turno + " ---");
            for (Personaje h : heroes) {
                if (!orco.estaVivo()) break;
                if (turno == 2 && h instanceof Habilidoso) {
                    ((Habilidoso) h).usarHabilidadEspecial(orco);
                } else {
                    h.atacar(orco);
                }
            }
            turno++;
        }

        System.out.println("\nBatalla terminada en " + (turno - 1) + " turno(s).");

        System.out.println("\n=== Fase 3: Sanación post batalla ===");

        Personaje masDebil = heroes.get(0);
        for (Personaje h : heroes) {
            if (h.puntosVida < masDebil.puntosVida) {
                masDebil = h;
            }
        }

        System.out.println("Heroe con menos vida: " + masDebil.nombre);

        for (Personaje h : heroes) {
            if (h instanceof Sanador) {
                ((Sanador) h).sanar(masDebil);
            }
        }

        System.out.println("\n=== Estado final ===");
        for (Personaje h : heroes) System.out.println(h);
        System.out.println(orco);
    }
}