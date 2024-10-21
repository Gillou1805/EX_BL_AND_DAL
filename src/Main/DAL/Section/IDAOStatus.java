package Main.DAL.Section;


import java.util.ArrayList;

import Main.BL.Section.Status;

public interface IDAOStatus {
    // M�thode pour r�cup�rer tous les statuts
    ArrayList<Status> getStatus();

    // M�thode pour r�cup�rer l'ID d'un statut � partir de son nom
    int getIDStatus(String status);

    // M�thode pour mettre � jour un statut
    void updateStatus(int id, String status);

    // M�thode pour supprimer un statut
    void deleteStatus(int id);

    // M�thode pour ajouter un statut
    void addStatus(String status);
}
