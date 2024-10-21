package Main.DAL.Section;


import java.util.ArrayList;

import Main.BL.Section.Status;

public interface IDAOStatus {
    // Méthode pour récupérer tous les statuts
    ArrayList<Status> getStatus();

    // Méthode pour récupérer l'ID d'un statut à partir de son nom
    int getIDStatus(String status);

    // Méthode pour mettre à jour un statut
    void updateStatus(int id, String status);

    // Méthode pour supprimer un statut
    void deleteStatus(int id);

    // Méthode pour ajouter un statut
    void addStatus(String status);
}
