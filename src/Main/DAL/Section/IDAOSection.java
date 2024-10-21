package Main.DAL.Section;

import java.util.ArrayList;

import Main.BL.Section.Section;

public interface IDAOSection {
    
    // Méthode pour récupérer toutes les sections
    ArrayList<Section> getSections();
    
    // Méthode pour récupérer l'ID d'une section à partir de son nom
    int getIDSection(String nom);
    
    // Méthode pour mettre à jour une section
    void updateSection(int id, String nom);
    
    // Méthode pour supprimer une section
    void deleteSection(int id);
    
    // Méthode pour ajouter une section
    void addSection(String nom);
}

