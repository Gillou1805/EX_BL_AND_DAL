package Main.BL.Section;

import java.util.ArrayList;

import Main.DAL.Section.DAOCours;
import Main.DAL.Section.DAOCoursPersonne;
import Main.DAL.Section.DAOPersonne;
import Main.DAL.Section.DAOSection;
import Main.DAL.Section.DAOStatus;


public class Main {
    public static void main(String[] args) {
        DAOSection daoSection = new DAOSection();
        DAOCours daoCours = new DAOCours();
        DAOStatus daoStatus = new DAOStatus();
        DAOPersonne daoPersonne = new DAOPersonne();
        DAOCoursPersonne daoCoursPersonne = new DAOCoursPersonne();
        
        //Le main permet de créer la DB Test, d'y insérer les différentes tables avec les différentes relations, de tester les méthodes
        // et de pouvoir vérifier les différentes valeurs rentrées dans celles-ci.
          
        
     // Créations des tables
        daoSection.getSections();
        daoCours.getCours();
        daoStatus.getStatus();
        daoPersonne.getPersonne();
        daoCoursPersonne.getCours_Personne();

        
        // Ajout de sections
        daoSection.addSection("Informatique de gestion");
        daoSection.addSection("egekeg"); //erreur pour test méthode update
        
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
        
        //ajout de Personne
       
        daoPersonne.addPersonne(2, "Poulet", "Gilles");
        daoPersonne.addPersonne(2, "Godissart", "Emmanuel");
        daoPersonne.addPersonne(3, "Lai", "Valeria");
        daoPersonne.addPersonne(3, "Mairesse", "David");
        daoPersonne.addPersonne(1, "Durant", "Richard");
        daoPersonne.addPersonne(1, "Ortiz", "Valerie");
        daoPersonne.addPersonne(1, "Borgelion", "Gilles");
        
        //ajoute de coursPersonne
        
        daoCoursPersonne.addCoursPersonne(1, 2, 2);
        daoCoursPersonne.addCoursPersonne(2, 1, 2);
        daoCoursPersonne.addCoursPersonne(5, 2, 3);
        daoCoursPersonne.addCoursPersonne(5, 1, 3);



     
        // Mettre à jour une section
        int id = daoSection.getIDSection("egekeg");
        daoSection.updateSection(id, " Droit ");
        
        
        
         //Supprimer une personne ( Borgelion Gilles)
        daoPersonne.deletePersonne(7);
        
        //Afficher les données des tables
        daoSection.getSectionsContent();
        daoCours.getCoursContent();
        daoStatus.getStatusContent();
        daoPersonne.getPersonneContent();
        daoCoursPersonne.getCours_PersonneContent();
        
        // Fermer la connexion
        daoSection.closeConnection();
    }
}

