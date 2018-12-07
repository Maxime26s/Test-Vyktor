import troupes.Commandant;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Commandant commandant = new Commandant();

    public static void main(String[] args) {
        while (true)
            choix(listeChoix());
    }

    private static int listeChoix() {
        System.out.print("Que désirez-vous faire ?\n" +
                " 1- Afficher la liste des soldats\n" +
                " 2- Afficher le soldat avec le plus d'attaque\n" +
                " 3- Afficher le soldat avec le moins de vie\n" +
                " 4- Vérifier si un soldat existe avec une vie précise\n" +
                " 5- Afficher la moyenne de vies et d'attaques\n" +
                " 6- Quitter le programme\n" +
                "Votre choix : ");
        return testInt();
    }

    private static void choix(int choixInt) {
        switch (choixInt) {
            case 1:
                afficherListe();
                break;
            case 2:
                plusAttaque();
                break;
            case 3:
                moinsVie();
                break;
            case 4:
                search();
                break;
            case 5:
                moyenne();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("ERREUR: Entrez un nombre valide");
                break;
        }
    }

    private static void afficherListe() {
        for (int i = 0; i < commandant.getSoldats().length; i++)
            System.out.println("Soldat #" + (i + 1) + ": " + "\n" +
                    "   - Vie: " + commandant.getSoldats()[i].getVie() + "\n" +
                    "   - Attaque: " + commandant.getSoldats()[i].getAttaque());
    }

    private static void plusAttaque() {
        int attaque = 0;
        int numero = 0;
        for (int i = 0; i < commandant.getSoldats().length; i++) {
            if (commandant.getSoldats()[i].getAttaque() > attaque) {
                attaque = commandant.getSoldats()[i].getAttaque();
                numero = i;
            }
        }
        System.out.println("Soldat #" + (numero + 1) + ": " + "\n" +
                "Vie: " + commandant.getSoldats()[numero].getVie() + "\n" +
                "Attaque: " + commandant.getSoldats()[numero].getAttaque());
    }

    private static void moinsVie() {
        int vie = 200;
        int numero = 0;
        for (int i = 0; i < commandant.getSoldats().length; i++) {
            if (commandant.getSoldats()[i].getVie() < vie) {
                vie = commandant.getSoldats()[i].getVie();
                numero = i;
            }
        }
        System.out.println("Soldat #" + (numero + 1) + ": " + "\n" +
                "Vie: " + commandant.getSoldats()[numero].getVie() + "\n" +
                "Attaque: " + commandant.getSoldats()[numero].getAttaque());
    }

    private static void search() {
        System.out.println("Combien de points de vie cherchez-vous?");
        int nbVie = testInt();
        for (int i = 0; i < commandant.getSoldats().length; i++) {
            if (commandant.getSoldats()[i].getVie() == nbVie)
                System.out.println("Soldat #" + (i + 1) + ": " + "\n" +
                        "Vie: " + commandant.getSoldats()[i].getVie() + "\n" +
                        "Attaque: " + commandant.getSoldats()[i].getAttaque());
        }
    }

    private static void moyenne() {
        float vieMoyenne = 0;
        float attaqueMoyenne = 0;
        for (int i = 0; i < commandant.getSoldats().length; i++) {
            vieMoyenne += commandant.getSoldats()[i].getVie();
            attaqueMoyenne += commandant.getSoldats()[i].getAttaque();
        }
        System.out.print("Vie moyenne: " + (int) (vieMoyenne / commandant.getSoldats().length) + "\n" +
                "Attaque moyenne: " + (int) (attaqueMoyenne / commandant.getSoldats().length));

    }

    private static int testInt() {
        try {
            String stringTemp = sc.nextLine();
            int intTemp = Integer.parseInt(stringTemp);
            return intTemp;
        } catch (Exception e) {
            System.out.println("ERREUR: Entrez un nombre valide");
            return testInt();
        }
    }
}
