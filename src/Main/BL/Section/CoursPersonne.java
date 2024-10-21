package Main.BL.Section;

public class CoursPersonne {
    private int id_personne;  // Clé primaire et étrangère vers la table Personne
    private int id_cours;      // Clé primaire et étrangère vers la table Cours
    private int annee;         // Clé primaire

    // Constructeur
    public CoursPersonne(int id_personne, int id_cours, int annee) {
        this.id_personne = id_personne;
        this.id_cours = id_cours;
        this.annee = annee;
    }

    public CoursPersonne() {
    }

    // Getters et Setters
    public int getId_personne() {
        return id_personne;
    }

    public void setId_personne(int id_personne) {
        this.id_personne = id_personne;
    }

    public int getId_cours() {
        return id_cours;
    }

    public void setId_cours(int id_cours) {
        this.id_cours = id_cours;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }
}

