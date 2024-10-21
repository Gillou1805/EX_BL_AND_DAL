package Main.DAL.Section;
import java.util.ArrayList;
import Main.BL.Section.Cours;

public interface IDAOCours {

    // Méthode pour récupérer tous les cours
    ArrayList<Cours> getCours();

    // Méthode pour récupérer l'ID d'un cours à partir de son nom
    int getIDCours(String nom);

    // Méthode pour mettre à jour un cours, avec la FK id_Section
    void updateCours(int id, String nom, int id_Section);

    // Méthode pour supprimer un cours
    void deleteCours(int id);

    // Méthode pour ajouter un cours, avec la FK id_Section
    void addCours(String nom, int id_Section);
}
