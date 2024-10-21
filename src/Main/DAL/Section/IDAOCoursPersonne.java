package Main.DAL.Section;

import java.util.ArrayList;
import Main.BL.Section.CoursPersonne;

public interface IDAOCoursPersonne {
    ArrayList<CoursPersonne> getCours_Personne();

    // M�thode pour r�cup�rer le contenu de la table Cours_personne
    ArrayList<CoursPersonne> getCours_PersonneContent();

    // M�thode pour ajouter une entr�e dans Cours_personne
    void addCoursPersonne(int id_personne, int id_cours, int annee);

    // M�thode pour mettre � jour une entr�e dans Cours_personne
    void updateCoursPersonne(int id_personne, int id_cours, int annee);

    // M�thode pour supprimer une entr�e dans Cours_personne
    void deleteCoursPersonne(int id_personne, int id_cours, int annee);

    // M�thode pour fermer la connexion � la base de donn�es
    void closeConnection();
}

