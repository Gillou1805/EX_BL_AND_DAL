package Main.BL.Section;

public class Cours {
    private String nom;
    private final int id;
    private int id_Section; // Clé étrangère qui fait référence à la Section

    // Constructeur avec id, nom et id_Section
    public Cours(int id, String nom, int id_Section) {
        this.id = id;
        this.nom = nom;
        this.id_Section = id_Section;
    }

    // Getter pour l'attribut 'nom'
    public String getNom() {
        return this.nom;
    }

    // Setter pour l'attribut 'nom'
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter pour l'attribut 'id'
    public int getId() {
        return this.id;
    }

    // Getter pour l'attribut 'id_Section' (la clé étrangère)
    public int getIdSection() {
        return this.id_Section;
    }

    // Setter pour l'attribut 'id_Section' (la clé étrangère)
    public void setIdSection(int id_Section) {
        this.id_Section = id_Section;
    }
}
