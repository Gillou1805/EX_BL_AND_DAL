package Main.BL.Section;

import java.util.ArrayList;

import Main.DAL.Section.DAOCours;
import Main.DAL.Section.DAOSection;
import Main.DAL.Section.DAOStatus;


public class Main {
    public static void main(String[] args) {
        DAOSection daoSection = new DAOSection();
        DAOCours daoCours = new DAOCours();
        DAOStatus daoStatus = new DAOStatus();
        
     // Créations des tables
        daoSection.getSections();
        daoCours.getCours();
        daoStatus.getStatus();
        
        // Ajout de sections
        daoSection.addSection("Informatique de gestion");
        daoSection.addSection("egekeg");
        
        //Ajout des cours
        daoCours.addCours("Base de réseaux", 1);
        daoCours.addCours("Système d'exploitation", 1);
        daoCours.addCours("Programmation orienté objet", 1);
        daoCours.addCours("Droit civil", 2);
        daoCours.addCours("Droit commercial", 2);
        
        //Ajout des status
        daoStatus.addStatus("Etudiant");
        daoStatus.addStatus("Charge de cours");
        daoStatus.addStatus("Employée administratif");
     
        // Mettre à jour une section
        int id = daoSection.getIDSection("egekeg");
        daoSection.updateSection(id, " Droit ");
        
        
        
         //Supprimer une section
        //daoSection.deleteSection(id);
        
        //Afficher les données des tables
        daoSection.getSectionsContent();
        daoCours.getCoursContent();
        daoStatus.getStatusContent();
        
        // Fermer la connexion
        daoSection.closeConnection();
    }
}

