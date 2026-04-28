package rpgmanager.model;

import rpgmanager.interfaces.Habilidoso;
import rpgmanager.interfaces.Equipable;

public class Guerrero extends Personaje implements Habilidoso, Equipable {

    private int fuerza;
    private int defensa;
    private String itemEquipado = "Sin equipo";
    private int costoHabilidad = 30;

    public Guerrero(String nombre, int nivel) {
        super(nombre, nivel, 100 + nivel * 10);
        this.fuerza = 15 + nivel * 3;
        this.defensa = 10 + nivel * 2;
    }

    @Override
    public void atacar(Personaje objetivo) {
        System.out.println(nombre + " golpea a " + objetivo.nombre + " con fuerza " + fuerza + "!");
        objetivo.recibirDano(fuerza);
    }

    @Override
    public String getTipoPersonaje() { return "Guerrero"; }

    public void usarEscudo() {
        System.out.println(nombre + " bloquea con su escudo (defensa: " + defensa + ")");
    }

    @Override
    public void usarHabilidadEspecial(Personaje objetivo) {
        System.out.println(nombre + " usa ¡Golpe Devastador! sobre " + objetivo.nombre);
        objetivo.recibirDano(50);
    }

    @Override
    public int getCostoHabilidad() { return costoHabilidad; }

    @Override
    public String getNombreHabilidad() { return "Golpe Devastador"; }
    

    @Override
    public void equiparItem(String item) {
        this.itemEquipado = item;
        System.out.println(nombre + " equipó: " + item);
    }

    @Override
    public String getItemEquipado() { return itemEquipado; }
}
        
