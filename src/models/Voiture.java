package models;

public class Voiture {
    // MR Tu as oublié le mot-clé final pour indiquer que ces valeurs ne changeront pas
    private int numero;
    private String nomEquipe;

    public Voiture(int numero, String nomEquipe) {
        this.numero = numero;
        this.nomEquipe = nomEquipe;
    }

    public int getNumero() {
        return numero;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    @Override
    public String toString() {
        // MR Le formatage du numéro de la voiture est incorrect
        // Il faut utiliser un DecimalFormat pour afficher le numéro avec un zéro devant ('000')
        return "Voiture No ; " + numero + " de l'équipe '" + nomEquipe + "'";
    }

    
    
}
