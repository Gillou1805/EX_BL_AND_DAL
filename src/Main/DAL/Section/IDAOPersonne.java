package Main.DAL.Section;

import java.util.ArrayList;

import Main.BL.Section.Personne;

public interface IDAOPersonne {
    ArrayList<Personne> getPersonne();

    // Méthode pour récupérer l'ID d'une personne à partir de son nom
    int getIDPersonne(String nom);

    // Méthode pour ajouter une personne
    void addPersonne(int id_status, String nom, String prenom);

    // Méthode pour mettre à jour une personne
    void updatePersonne(int id, int id_status, String nom, String prenom);

    // Méthode pour supprimer une personne
    void deletePersonne(int id);
}

