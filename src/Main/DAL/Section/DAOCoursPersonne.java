package Main.DAL.Section;

import java.sql.*;
import java.util.ArrayList;

import Main.BL.Section.CoursPersonne;

public class DAOCoursPersonne implements IDAOCoursPersonne {
    Connection connexion = null;

    public DAOCoursPersonne() {
        try {
            // Initialisation de la connexion à la base de données
            connexion = DriverManager.getConnection("jdbc:postgresql://localhost/", "postgres", "Test01");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public ArrayList<CoursPersonne> getCours_Personne() {
        ArrayList<CoursPersonne> liste = new ArrayList<>();
        Statement requete = null;

        try {
        	connexion = DriverManager.getConnection("jdbc:postgresql://localhost/test", "postgres", "Test01");
            requete = connexion.createStatement();

            // Créer la table Cours_personne si elle n'existe pas
            requete.executeUpdate("CREATE TABLE IF NOT EXISTS Cours_personne ("
                    + "id_personne INT, "
                    + "id_cours INT, "
                    + "annee INT, "
                    + "PRIMARY KEY (id_personne, id_cours, annee), "
                    + "FOREIGN KEY (id_personne) REFERENCES Personne(id), "
                    + "FOREIGN KEY (id_cours) REFERENCES Cours(id))");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (requete != null) {
                try {
                    requete.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return liste;
    }

    public ArrayList<CoursPersonne> getCours_PersonneContent() {
        ArrayList<CoursPersonne> liste = new ArrayList<>();
        Statement requete = null;
        ResultSet set = null;

        try {
            requete = connexion.createStatement();

            // Récupérer le contenu de la table Cours_personne
            set = requete.executeQuery("SELECT * FROM Cours_personne");

            // Parcourir les résultats et ajouter chaque cours-personne à la liste
            while (set.next()) {
                CoursPersonne coursPersonne = new CoursPersonne();
                coursPersonne.setId_personne(set.getInt("id_personne"));
                coursPersonne.setId_cours(set.getInt("id_cours"));
                coursPersonne.setAnnee(set.getInt("annee"));
                liste.add(coursPersonne);
            }

            // Impression des données 
            System.out.println("Contenu de la table Cours_personne :");
            for (CoursPersonne coursPersonne : liste) {
                System.out.println("ID Personne: " + coursPersonne.getId_personne() +
                                   ", ID Cours: " + coursPersonne.getId_cours() +
                                   ", Année: " + coursPersonne.getAnnee());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (requete != null) {
                try {
                    requete.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return liste;
    }


    // Méthode pour ajouter une entrée dans Cours_personne
    public void addCoursPersonne(int id_personne, int id_cours, int annee) {
        String sql = "INSERT INTO Cours_personne (id_personne, id_cours, annee) VALUES (?, ?, ?)";
        try (PreparedStatement insertCoursPersonne = connexion.prepareStatement(sql)) {
            insertCoursPersonne.setInt(1, id_personne);
            insertCoursPersonne.setInt(2, id_cours);
            insertCoursPersonne.setInt(3, annee);
            insertCoursPersonne.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // mettre à jour une entrée dans Cours_personne
    public void updateCoursPersonne(int id_personne, int id_cours, int annee) {
        String sql = "UPDATE Cours_personne SET annee=? WHERE id_personne=? AND id_cours=?";
        try (PreparedStatement updateCoursPersonne = connexion.prepareStatement(sql)) {
            updateCoursPersonne.setInt(1, annee);
            updateCoursPersonne.setInt(2, id_personne);
            updateCoursPersonne.setInt(3, id_cours);
            updateCoursPersonne.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // supprimer une entrée dans Cours_personne
    public void deleteCoursPersonne(int id_personne, int id_cours, int annee) {
        String sql = "DELETE FROM Cours_personne WHERE id_personne=? AND id_cours=? AND annee=?";
        try (PreparedStatement deleteCoursPersonne = connexion.prepareStatement(sql)) {
            deleteCoursPersonne.setInt(1, id_personne);
            deleteCoursPersonne.setInt(2, id_cours);
            deleteCoursPersonne.setInt(3, annee);
            deleteCoursPersonne.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public void closeConnection() {
        if (connexion != null) {
            try {
                connexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

