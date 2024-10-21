package Main.DAL.Section;

import java.util.ArrayList;

import Main.BL.Section.Section;

public interface IDAOSection {
    
    ArrayList<Section> getSections();
    
    // M�thode pour r�cup�rer l'ID d'une section � partir de son nom
    int getIDSection(String nom);
    
    // M�thode pour mettre � jour une section
    void updateSection(int id, String nom);
    
    // M�thode pour supprimer une section
    void deleteSection(int id);
    
    // M�thode pour ajouter une section
    void addSection(String nom);
}

