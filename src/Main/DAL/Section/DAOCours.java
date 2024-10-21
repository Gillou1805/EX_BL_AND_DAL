package Main.DAL.Section;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Main.BL.Section.Cours;

public class DAOCours implements IDAOCours {

    Connection connexion = null;

    public DAOCours() {
        try {
            // Initialisation de la connexion à la base de données
            connexion = DriverManager.getConnection("jdbc:postgresql://localhost/", "postgres", "Test01");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ajouter un cours avec id_Section (clé étrangère)
    public void addCours(String nom, int id_Section) {
        String sql = "INSERT INTO Cours (nom, id_Section) VALUES (?, ?)";
        try (PreparedStatement insertCours = connexion.prepareStatement(sql)) {
            insertCours.setString(1, nom);
            insertCours.setInt(2, id_Section);
            insertCours.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour mettre à jour un cours, y compris la section (id_Section)
    public void updateCours(int id, String nom, int id_Section) {
        String sql = "UPDATE Cours SET nom=?, id_Section=? WHERE id=?";
        try (PreparedStatement updateCours = connexion.prepareStatement(sql)) {
            updateCours.setString(1, nom);
            updateCours.setInt(2, id_Section);
            updateCours.setInt(3, id);
            updateCours.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour supprimer un cours
    public void deleteCours(int id) {
        String sql = "DELETE FROM Cours WHERE id=?";
        try (PreparedStatement deleteCours = connexion.prepareStatement(sql)) {
            deleteCours.setInt(1, id);
            deleteCours.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour récupérer l'ID d'un cours via son nom
    public int getIDCours(String nom) {
        String sql = "SELECT id FROM Cours WHERE nom=?";
        int id = -1;
        try (PreparedStatement getIDCours = connexion.prepareStatement(sql)) {
            getIDCours.setString(1, nom);
            ResultSet resultSet = getIDCours.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
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
    
    public ArrayList<Cours> getCoursContent() {
        ArrayList<Cours> liste = new ArrayList<>();
        Statement requete = null;
        ResultSet set = null;

        try {
            // Établir la connexion à la base de données
            connexion = DriverManager.getConnection("jdbc:postgresql://localhost/test", "postgres", "Test01");
            requete = connexion.createStatement();

            // Exécuter la requête pour récupérer les données des cours
            set = requete.executeQuery("SELECT id, nom, id_section FROM Cours");

            // Parcourir les résultats et ajouter chaque cours à la liste
            while (set.next()) {
                int id = set.getInt("id");
                String nom = set.getString("nom");
                int idSection = set.getInt("id_section");

                // Créer un objet Cours avec les données récupérées
                Cours cours = new Cours(id, nom, idSection);
                liste.add(cours);
            }

            // Optionnel : imprimer les cours récupérés pour débogage
            for (Cours cours : liste) {
                System.out.println("Cours: " + cours.getNom() + " (ID: " + cours.getId() + ", Section ID: " + cours.getIdSection() + ")");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Fermer le ResultSet et le Statement
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

    public ArrayList<Cours> getCours() {
        ArrayList<Cours> liste = new ArrayList<>();
        Statement requete = null;
        ResultSet set = null;

        try {
            // Établir la connexion à la base de données test
            connexion = DriverManager.getConnection("jdbc:postgresql://localhost/test", "postgres", "Test01");
            requete = connexion.createStatement();

            // Créer la table "Cours" si elle n'existe pas encore
            try {
                requete.executeUpdate("CREATE TABLE IF NOT EXISTS Cours (id SERIAL PRIMARY KEY, nom VARCHAR(30), id_Section INT, FOREIGN KEY (id_Section) REFERENCES Section(id))");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            // Exécuter la requête pour récupérer les cours
            set = requete.executeQuery("SELECT id, nom, id_Section FROM Cours");

            // Parcourir les résultats et ajouter chaque cours à la liste
            while (set.next()) {
                int id = set.getInt("id");
                String nom = set.getString("nom");
                int id_Section = set.getInt("id_Section");

                // Créer un objet Cours avec l'ID, le nom et la clé étrangère id_Section
                Cours cours = new Cours(id, nom, id_Section);
                liste.add(cours);
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
}

