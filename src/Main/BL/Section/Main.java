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
        
        //Le main permet de cr�er la DB Test, d'y ins�rer les diff�rentes tables avec les diff�rentes relations, de tester les m�thodes
        // et de pouvoir v�rifier les diff�rentes valeurs rentr�es dans celles-ci.
          
        
     // Cr�ations des tables
        daoSection.getSections();
        daoCours.getCours();
        daoStatus.getStatus();
        daoPersonne.getPersonne();
        daoCoursPersonne.getCours_Personne();

        
        // Ajout de sections
        daoSection.addSection("Informatique de gestion");
        daoSection.addSection("egekeg"); //erreur pour test m�thode update
        
        //Ajout des cours
        daoCours.addCours("Base de r�seaux", 1);
        daoCours.addCours("Syst�me d'exploitation", 1);
        daoCours.addCours("Programmation orient� objet", 1);
        daoCours.addCours("Droit civil", 2);
        daoCours.addCours("Droit commercial", 2);
        
       
        //Ajout des status
        daoStatus.addStatus("Etudiant");
        daoStatus.addStatus("Charge de cours");
        daoStatus.addStatus("Employ�e administratif");
        
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



     
        // Mettre � jour une section
        int id = daoSection.getIDSection("egekeg");
        daoSection.updateSection(id, " Droit ");
        
        
        
         //Supprimer une personne ( Borgelion Gilles)
        daoPersonne.deletePersonne(7);
        
        //Afficher les donn�es des tables
        daoSection.getSectionsContent();
        daoCours.getCoursContent();
        daoStatus.getStatusContent();
        daoPersonne.getPersonneContent();
        daoCoursPersonne.getCours_PersonneContent();
        
        // Fermer la connexion
        daoSection.closeConnection();
    }
}

