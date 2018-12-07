package troupes;

public class Commandant {
    private Soldat[] soldats;

    public Commandant() {
        this.soldats = new Soldat[(int) (Math.random() * 50) + 25];
        for (int i = 0; i < soldats.length; i++)
            soldats[i] = new Soldat();
    }

    public Soldat[] getSoldats() {
        return soldats;
    }
}
