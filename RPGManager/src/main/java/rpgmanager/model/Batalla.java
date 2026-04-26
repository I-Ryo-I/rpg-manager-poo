package rpgmanager.model;

import java.util.ArrayList;

public class Batalla {

    public static void main(String[] args) {

        ArrayList<Personaje> heroes = new ArrayList<>();
        heroes.add(new Guerrero("Thorin", 3));
        heroes.add(new Mago("Gandalf", 5));
        heroes.add(new Arquero("Legolas", 4));

        Personaje orco = new Guerrero("Orco", 1);
        int turno = 1;

        while (orco.estaVivo()) {
            System.out.println("\n--- Turno " + turno + " ---");
            for (Personaje h : heroes) {
                if (orco.estaVivo()) {
                    h.atacar(orco);
                }
            }
            turno++;
        }

        System.out.println("\nBatalla terminada en " + (turno - 1) + " turno(s).");
        System.out.println("\n=== Estado final ===");
        for (Personaje h : heroes) System.out.println(h);
        System.out.println(orco);
    }
}
