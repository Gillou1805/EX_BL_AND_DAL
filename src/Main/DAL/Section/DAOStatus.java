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
            // Initialisation de la connexion � la base de donn�es
            connexion = DriverManager.getConnection("jdbc:postgresql://localhost/", "postgres", "Test01");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // M�thode pour ajouter un statut
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

    // M�thode pour mettre � jour un statut
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

    // M�thode pour supprimer un statut
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

    // M�thode pour r�cup�rer l'ID d'un statut via son nom
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
            // �tablir la connexion � la base de donn�es
            connexion = DriverManager.getConnection("jdbc:postgresql://localhost/test", "postgres", "Test01");
            requete = connexion.createStatement();

            // Ex�cuter la requ�te pour r�cup�rer le contenu de la table Status
            set = requete.executeQuery("SELECT * FROM Status");

            // Parcourir les r�sultats et ajouter chaque statut � la liste
            while (set.next()) {
                Status status = new Status(set.getInt("id"), set.getString("status"));
                liste.add(status);
            }

            // Optionnel : imprimer les statuts r�cup�r�s pour d�bogage
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

    // M�thode pour r�cup�rer tous les statuts
    @Override
    public ArrayList<Status> getStatus() {
        ArrayList<Status> liste = new ArrayList<>();
        Statement requete = null;
        ResultSet set = null;

        try {
            // �tablir la connexion � la base de donn�es
            connexion = DriverManager.getConnection("jdbc:postgresql://localhost/test", "postgres", "Test01");
            requete = connexion.createStatement();

            // Cr�er la table Status si elle n'existe pas d�j�
            try {
                requete.executeUpdate("CREATE TABLE IF NOT EXISTS Status (id SERIAL PRIMARY KEY, status VARCHAR(30) NOT NULL)");
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // Ex�cuter la requ�te pour r�cup�rer tous les statuts
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
