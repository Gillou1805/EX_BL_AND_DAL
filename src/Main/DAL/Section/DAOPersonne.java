package Main.DAL.Section;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Main.BL.Section.Personne;

public class DAOPersonne implements IDAOPersonne {
    
    Connection connexion = null;

    public DAOPersonne() {
        try {
            // Initialisation de la connexion à la base de données
            connexion = DriverManager.getConnection("jdbc:postgresql://localhost/", "postgres", "Test01");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour ajouter une personne
    public void addPersonne( int id_status, String nom, String prenom) {
        String sql = "INSERT INTO Personne (nom, prenom, id_status) VALUES (?, ?, ?)";
        try (PreparedStatement insertPersonne = connexion.prepareStatement(sql)) {
            insertPersonne.setString(1, nom);
            insertPersonne.setString(2, prenom);
            insertPersonne.setInt(3, id_status);
            insertPersonne.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // mettre à jour une personne
    public void updatePersonne(int id, int id_status, String nom, String prenom) {
        String sql = "UPDATE Personne SET nom=?, prenom=?, id_status=? WHERE id=?";
        try (PreparedStatement updatePersonne = connexion.prepareStatement(sql)) {
            updatePersonne.setString(1, nom);
            updatePersonne.setString(2, prenom);
            updatePersonne.setInt(3, id_status);
            updatePersonne.setInt(4, id);
            updatePersonne.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour supprimer une personne
    public void deletePersonne(int id) {
        String sql = "DELETE FROM Personne WHERE id=?";
        try (PreparedStatement deletePersonne = connexion.prepareStatement(sql)) {
            deletePersonne.setInt(1, id);
            deletePersonne.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour récupérer l'ID d'une personne via son nom
    public int getIDPersonne(String nom) {
        String sql = "SELECT id FROM Personne WHERE nom=?";
        int id = -1;
        try (PreparedStatement getIDPersonne = connexion.prepareStatement(sql)) {
            getIDPersonne.setString(1, nom);
            ResultSet resultSet = getIDPersonne.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    //  créer la table Personne si elle n'existe pas encore
    public ArrayList<Personne> getPersonne() {
        ArrayList<Personne> liste = new ArrayList<>();
        Statement requete = null;
        ResultSet set = null;

        try {
            connexion = DriverManager.getConnection("jdbc:postgresql://localhost/test", "postgres", "Test01");
            requete = connexion.createStatement();

            // Créer la table Personne si elle n'existe pas
            try {
                requete.executeUpdate("CREATE TABLE IF NOT EXISTS Personne ("
                        + "id SERIAL PRIMARY KEY, "
                        + "nom VARCHAR(15), "
                        + "prenom VARCHAR(15), "
                        + "id_status INT, "
                        + "FOREIGN KEY (id_status) REFERENCES Status(id))");
            } catch (SQLException ex) {
                ex.printStackTrace();
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



    // Méthode pour afficher le contenu de la table Personne
    public ArrayList<Personne> getPersonneContent() {
        ArrayList<Personne> liste = new ArrayList<>();
        Statement requete = null;
        ResultSet set = null;

        try {
            connexion = DriverManager.getConnection("jdbc:postgresql://localhost/test", "postgres", "Test01");
            requete = connexion.createStatement();

            // Récupérer le contenu de la table Personne
            set = requete.executeQuery("SELECT p.nom, p.prenom, s.status "
                                        + "FROM Personne p "
                                        + "JOIN Status s ON p.id_status = s.id");

            // Parcourir les résultats et ajouter chaque personne à la liste
            while (set.next()) {
                Personne personne = new Personne();
                personne.setNom(set.getString("nom"));
                personne.setPrenom(set.getString("prenom"));
                liste.add(personne);
            }

            for (Personne personne : liste) {
                System.out.println("Personne: " + personne.getNom() + " " + personne.getPrenom());
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

