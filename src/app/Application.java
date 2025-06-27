package app;

import models.Pilote;
import models.Pneu;
import models.TypePneu;
import models.Voiture;

public class Application {

    public static void main(String[] args) {

        // ---------------------------------------------------------------------------------------
        // Etape 1 : Création d'une voiture de Formule 1
        // ---------------------------------------------------------------------------------------
        Voiture voiture1 = new Voiture(16, "Ferrari");
        // ---------------------------------------------------------------------------------------
        // Etape 2 : Afficher la voiture
        // ---------------------------------------------------------------------------------------
        System.out.println(voiture1.toString());
        // ---------------------------------------------------------------------------------------
        // Etape 3 : Création d'un pilote de Formule 1 et afficher ses informations
        // ---------------------------------------------------------------------------------------
        Pilote pilote1 = new Pilote("Charles Leclerc", "Monégasque", voiture1);
        pilote1.setNombreCourse(16);
        pilote1.setNombrePoint(65);
        pilote1.setNombreVictoire(3);
        pilote1.setNombrePodiums(7);
        // ---------------------------------------------------------------------------------------
        // Etape 4 : Afficher le Pilote
        // ---------------------------------------------------------------------------------------
        System.out.println(pilote1.toString());
        // ---------------------------------------------------------------------------------------
        // Etape 5 : Tests des méthodes de la classe Pilote
        // ---------------------------------------------------------------------------------------
        // deposerPneuEnReserve() 5 fois de types différents
        Pneu pneu1 = new Pneu(TypePneu.DUR_BLANC, 1.5);
        Pneu pneu2 = new Pneu(TypePneu.MEDIUM_JAUNE, 1.8);
        Pneu pneu3 = new Pneu(TypePneu.TENDRE_ROUGE, 2.0);
        Pneu pneu4 = new Pneu(TypePneu.DUR_BLANC, 1.6);
        Pneu pneu5 = new Pneu(TypePneu.MEDIUM_JAUNE, 1.7);
        pilote1.deposerPneuEnReserve(pneu1);
        pilote1.deposerPneuEnReserve(pneu2);
        pilote1.deposerPneuEnReserve(pneu3);
        pilote1.deposerPneuEnReserve(pneu4);
        pilote1.deposerPneuEnReserve(pneu5);

        // retirerPneuEnReserve() de type TENDRE_ROUGE et l'afficher
        System.out.println(pilote1.retirerPneuEnReserve(TypePneu.TENDRE_ROUGE));
        // getNombrePneusEnReserve() et afficher le nombre de pneus en réserve
        System.out.println("nombre total en réserve: " + pilote1.getNombrePneusEnReserve());
        // getPneusEnReserveSansTrous() et afficher les pneus en réserve
        Pneu[] pneus = pilote1.getPneusEnReserveSansTrous();
        for (int i = 0; i < pneus.length; i++) {
            System.out.println(pneus[i]);
        }
        // pressionMoyenneDesPneusEnReserveFormatee() et afficher la pression moyenne
        // des
        // pneus
        System.out.println(pilote1.pressionMoyenneDesPneusEnReserveFormatee());
        // compterNombrePneusEnReserveDeType() et afficher le nombre de pneus en réserve
        // de type DUR_BLANC
        System.out.println(
                "pneu en reserve de type DUR_BLANC: " + pilote1.compterNombrePneusEnReserveDeType(TypePneu.DUR_BLANC));
        // Créer les 3 pneus et ajout le lot de pneus pour le pilote et afficher réussi
        // ou échoué
        Pneu pneuB1 = new Pneu(TypePneu.DUR_BLANC, 1.3);
        Pneu pneuB2 = new Pneu(TypePneu.DUR_BLANC, 1.2);
        Pneu pneuB3 = new Pneu(TypePneu.DUR_BLANC, 1.1);
        Pneu[] lot1 = new Pneu[5];
        lot1[0] = pneuB1;
        lot1[2] = pneuB2;
        lot1[3] = pneuB3;
        boolean resultat = pilote1.ajouterLotDePneu(lot1);
        if (resultat) {
            System.out.println("Ajout réussi");
        } else {
            System.out.println("Ajout échoué");
        }
        // Supprimer les pneus de pression inférieure à 1.4 et afficher le nombre de
        // pneus supprimés
        System.out.println(pilote1.suprimerPneusDePressionInferieur(1.4));
        // ---------------------------------------------------------------------------------------

    }

}
