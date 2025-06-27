package models;

public class Voiture {
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
        return "Voiture No ; " + numero + " de l'équipe '" + nomEquipe + "'";
    }

    
    
}
