package Main.DAL.Section;

import java.util.ArrayList;

import Main.BL.Section.Personne;

public interface IDAOPersonne {
    ArrayList<Personne> getPersonne();

    // M�thode pour r�cup�rer l'ID d'une personne � partir de son nom
    int getIDPersonne(String nom);

    // M�thode pour ajouter une personne
    void addPersonne(int id_status, String nom, String prenom);

    // M�thode pour mettre � jour une personne
    void updatePersonne(int id, int id_status, String nom, String prenom);

    // M�thode pour supprimer une personne
    void deletePersonne(int id);
}

