package Main.DAL.Section;

import java.util.ArrayList;
import Main.BL.Section.CoursPersonne;

public interface IDAOCoursPersonne {
    ArrayList<CoursPersonne> getCours_Personne();

    // Méthode pour récupérer le contenu de la table Cours_personne
    ArrayList<CoursPersonne> getCours_PersonneContent();

    // Méthode pour ajouter une entrée dans Cours_personne
    void addCoursPersonne(int id_personne, int id_cours, int annee);

    // Méthode pour mettre à jour une entrée dans Cours_personne
    void updateCoursPersonne(int id_personne, int id_cours, int annee);

    // Méthode pour supprimer une entrée dans Cours_personne
    void deleteCoursPersonne(int id_personne, int id_cours, int annee);

    // Méthode pour fermer la connexion à la base de données
    void closeConnection();
}

