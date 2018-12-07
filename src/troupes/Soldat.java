package troupes;

public class Soldat {
    private int vie;
    private int attaque;

    public Soldat() {
        this.vie = (int) (Math.random() * 110) + 40;
        this.attaque = (int) (Math.random() * 50) + 10;
    }

    public int getVie() {
        return vie;
    }

    public int getAttaque() {
        return attaque;
    }
}
