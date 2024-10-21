package Main.DAL.Section;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Main.BL.Section.Status;

public class DAOStatus implements IDAOStatus {
    Connection connexion = null;

    public DAOStatus() {
        try {
            // Initialisation de la connexion à la base de données
            connexion = DriverManager.getConnection("jdbc:postgresql://localhost/", "postgres", "Test01");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour ajouter un statut
    @Override
    public void addStatus(String status) {
        String sql = "INSERT INTO Status (status) VALUES (?)";
        try (PreparedStatement insertStatus = connexion.prepareStatement(sql)) {
            insertStatus.setString(1, status);
            insertStatus.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour mettre à jour un statut
    @Override
    public void updateStatus(int id, String status) {
        String sql = "UPDATE Status SET status=? WHERE id=?";
        try (PreparedStatement updateStatus = connexion.prepareStatement(sql)) {
            updateStatus.setString(1, status);
            updateStatus.setInt(2, id);
            updateStatus.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour supprimer un statut
    @Override
    public void deleteStatus(int id) {
        String sql = "DELETE FROM Status WHERE id=?";
        try (PreparedStatement deleteStatus = connexion.prepareStatement(sql)) {
            deleteStatus.setInt(1, id);
            deleteStatus.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour récupérer l'ID d'un statut via son nom
    @Override
    public int getIDStatus(String status) {
        String sql = "SELECT id FROM Status WHERE status=?";
        int id = -1;
        try (PreparedStatement getIDStatus = connexion.prepareStatement(sql)) {
            getIDStatus.setString(1, status);
            ResultSet resultSet = getIDStatus.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
    
    public ArrayList<Status> getStatusContent() {
        ArrayList<Status> liste = new ArrayList<>();
        Statement requete = null;
        ResultSet set = null;

        try {
            // Établir la connexion à la base de données
            connexion = DriverManager.getConnection("jdbc:postgresql://localhost/test", "postgres", "Test01");
            requete = connexion.createStatement();

            // Exécuter la requête pour récupérer le contenu de la table Status
            set = requete.executeQuery("SELECT * FROM Status");

            // Parcourir les résultats et ajouter chaque statut à la liste
            while (set.next()) {
                Status status = new Status(set.getInt("id"), set.getString("status"));
                liste.add(status);
            }

            // Optionnel : imprimer les statuts récupérés pour débogage
            for (Status status : liste) {
                System.out.println("ID: " + status.getId() + ", Status: " + status.getStatus());
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

    // Méthode pour récupérer tous les statuts
    @Override
    public ArrayList<Status> getStatus() {
        ArrayList<Status> liste = new ArrayList<>();
        Statement requete = null;
        ResultSet set = null;

        try {
            // Établir la connexion à la base de données
            connexion = DriverManager.getConnection("jdbc:postgresql://localhost/test", "postgres", "Test01");
            requete = connexion.createStatement();

            // Créer la table Status si elle n'existe pas déjà
            try {
                requete.executeUpdate("CREATE TABLE IF NOT EXISTS Status (id SERIAL PRIMARY KEY, status VARCHAR(30) NOT NULL)");
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // Exécuter la requête pour récupérer tous les statuts
            set = requete.executeQuery("SELECT * FROM Status");

            while (set.next()) {
                Status status = new Status(set.getInt("id"), set.getString("status"));
                liste.add(status);
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
