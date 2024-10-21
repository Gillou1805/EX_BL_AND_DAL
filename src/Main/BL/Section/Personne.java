package Main.BL.Section;

public class Personne {
    private int id;
    private int id_status; // Clé étrangère vers la table Status
    private String nom;
    private String prenom;

    // Constructeur 
    public Personne(int id, int id_status, String nom, String prenom) {
        this.id = id;
        this.id_status = id_status;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Personne() {
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_status() {
        return id_status;
    }

    public void setId_status(int id_status) {
        this.id_status = id_status;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}

