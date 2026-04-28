package rpgmanager.model;

import rpgmanager.interfaces.Equipable;

public class Arquero extends Personaje implements Equipable {

    private int flechas;
    private int alcance;
    private String itemEquipado = "Arco básico";

    public Arquero(String nombre, int nivel) {
        super(nombre, nivel, 75 + nivel * 7);
        this.flechas = 10 + nivel * 2;
        this.alcance = 30;
    }

    @Override
    public void atacar(Personaje objetivo) {
        if (flechas > 0) {
            int dano = 12 + nivel * 4;
            if (!itemEquipado.equals("Arco básico")) dano += 5;
            flechas--;
            System.out.println(nombre + " dispara una flecha a " + objetivo.nombre + "! (Flechas: " + flechas + ")");
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

    // --- Equipable ---
    @Override
    public void equiparItem(String item) {
        this.itemEquipado = item;
        System.out.println(nombre + " equipó: " + item);
    }

    @Override
    public String getItemEquipado() { return itemEquipado; }
}