package rpgmanager.model;

public class Mago extends Personaje {
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

    public int getMana() { return mana; }
    public int getManaMax() { return manaMax; }
}
