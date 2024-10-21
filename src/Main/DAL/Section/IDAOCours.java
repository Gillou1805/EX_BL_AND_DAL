package Main.DAL.Section;
import java.util.ArrayList;
import Main.BL.Section.Cours;

public interface IDAOCours {

    // M�thode pour r�cup�rer tous les cours
    ArrayList<Cours> getCours();

    // M�thode pour r�cup�rer l'ID d'un cours � partir de son nom
    int getIDCours(String nom);

    // M�thode pour mettre � jour un cours, avec la FK id_Section
    void updateCours(int id, String nom, int id_Section);

    // M�thode pour supprimer un cours
    void deleteCours(int id);

    // M�thode pour ajouter un cours, avec la FK id_Section
    void addCours(String nom, int id_Section);
}
