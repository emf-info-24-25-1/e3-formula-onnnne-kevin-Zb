package models;


public class Pilote {
    public final static int NOMBRE_PNEUS_EN_RESERVE = 16;
    //MR Il faut mettre final pour indiquer que cette valeur ne changera pas pour les deux premiers attributs
    private String nom;
    private String nationalite;
    private int nombrePoint;
    private int nombreCourse;
    private int nombreVictoire;
    private int nombrePodiums;
    private Pneu[] pneusEnReserve;
    private Voiture voiture;
    
    public Pilote(String nom, String nationalite) {
        this.nom = nom;
        this.nationalite = nationalite;
        this.nombrePoint = 0;
        this.nombreCourse = 0;
        this.nombreVictoire = 0;
        this.nombrePodiums = 0;
        this.pneusEnReserve = new Pneu[NOMBRE_PNEUS_EN_RESERVE];
        this.voiture = null;
    }

    public Pilote(String nom, String nationalite, Voiture voiture) {
        this.nom = nom;
        this.nationalite = nationalite;
        this.nombrePoint = 0;
        this.nombreCourse = 0;
        this.nombreVictoire = 0;
        this.nombrePodiums = 0;
        this.pneusEnReserve = new Pneu[NOMBRE_PNEUS_EN_RESERVE];
        this.voiture = voiture;
    }
    
    public boolean deposerPneuEnReserve(Pneu pneu){
        boolean resultat = false;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] == null) {
                pneusEnReserve[i] = pneu;
                resultat = true;
                break;
            }
        }
        return resultat;
    }

    public Pneu retirerPneuEnReserve(TypePneu type){
        Pneu pneu = null;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            //MR Il faut aussi vérifier si pneusEnReserve[i] n'est pas null avant de comparer les types
            //MR Il faut mieux utiliser == pour comparer les types de pneus
            if (pneusEnReserve[i].getType().equals(type)) {
                pneu = pneusEnReserve[i];
                pneusEnReserve[i] = null;
                break;
            }
        }
        return pneu;
    }
    
    public int compterNombrePneusEnReserveDeType(TypePneu type){
        int total = 0;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            //MR Il faut aussi vérifier si pneusEnReserve[i] n'est pas null avant de comparer les types
            //MR Il faut mieux utiliser == pour comparer les types de pneus
            if (pneusEnReserve[i].getType().equals(type)) {
                total++;
            }
        }
        return total;
    }

    public int getNombrePneusEnReserve(){
        int total = 0;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                total++;
            }
        }
        return total;
    }

    public Pneu[] getPneusEnReserveSansTrous(){
        //MR C'est pas mal, mais il faut créer un tableau de la taille du nombre de pneus en réserve il faut donc compter le nombre de pneus non null avant
        //Ici ton tableau aura les éléments tous au début et les trous à la fin
        Pneu[] pneus = new Pneu[NOMBRE_PNEUS_EN_RESERVE];
        int compteur = 0;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                pneus[compteur] = pneusEnReserve[i];
                compteur++;
            }
        }
        return pneus;
    }

    public String pressionMoyenneDesPneusEnReserveFormatee(){
        double moyenne = 0;
        int compteur = 0;
        
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                moyenne += pneusEnReserve[i].getPression();
                compteur++;
            }
        }
        //MR Il faut vérifier si compteur n'est pas 0 pour éviter la division par zéro
        moyenne = moyenne / compteur;
        //j'aurais du rajouter le formateur de maniere suivante #'##0.00 pour la moyenne car il
        //est demander de mettre le bon formatage des milier et des décimales
        //MR En effet, il faut formater la moyenne pour l'afficher correctement
        String resultat = "pression moyenne des pneus de la réserve: " + moyenne;

        return resultat;
    }

    public int suprimerPneusDePressionInferieur(double pression){
        int total = 0;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                if (pneusEnReserve[i].getPression() < pression) {
                    pneusEnReserve[i] = null;
                    total++;
                }
            }
        }
        return total;
    }
    
    public boolean ajouterLotDePneu(Pneu[] pneu){
        boolean resultat = false;
        int pneuAAjouter = 0;
        int pneuAjoutable = 0;
        for (int i = 0; i < pneu.length; i++) {
            if (pneu[i] != null) {
                pneuAAjouter++;
            }
        }
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] == null) {
                pneuAjoutable++;
            }
        }

        if (pneuAjoutable >= pneuAAjouter) {
            resultat = true;
            for (int i = 0; i < pneusEnReserve.length; i++) {
                if (pneusEnReserve[i] == null) {
                    for (int j = 0; j < pneu.length; j++) {
                        if (pneu[j] != null) {
                            pneusEnReserve[i] = pneu[j];
                            pneu[j] = null;
                        }
                    }
                }
            }
        }
        return resultat;
    }

    public String getNom() {
        return nom;
    }

    public String getNationalite() {
        return nationalite;
    }

    public int getNombrePoint() {
        return nombrePoint;
    }

    public int getNombreCourse() {
        return nombreCourse;
    }

    public int getNombreVictoire() {
        return nombreVictoire;
    }

    public int getNombrePodiums() {
        return nombrePodiums;
    }

    public void setNombrePoint(int nombrePoint) {
        this.nombrePoint = nombrePoint;
    }

    public void setNombreCourse(int nombreCourse) {
        this.nombreCourse = nombreCourse;
    }

    public void setNombreVictoire(int nombreVictoire) {
        this.nombreVictoire = nombreVictoire;
    }

    public void setNombrePodiums(int nombrePodiums) {
        this.nombrePodiums = nombrePodiums;
    }

    @Override
    public String toString() {
        String resultat = "Pilote: " + nom + " (" + nationalite + ")\n" ;
        if (voiture != null) {
            String nomEquipe = voiture.getNomEquipe();
            int numero = voiture.getNumero();
            resultat += "-> Voiture " + nomEquipe + "(" + numero + ")\n";
            resultat += "-> Points: " + nombrePoint + "\n";
            resultat += "-> Courses: " + nombreCourse + "\n";
            resultat += "-> Victoires: " + nombreVictoire + "\n";
            resultat += "-> Podiums: " + nombrePodiums + "\n";
        }
        else{
            resultat += "-> Pas de voiture assignée.\n";
        }
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                TypePneu type = pneusEnReserve[i].getType();
                resultat += "-> Pneu en réserve: " + type + "\n";
            }
        }
        return resultat;
    }
}
