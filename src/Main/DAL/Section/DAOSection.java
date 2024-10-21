package Main.DAL.Section;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Main.BL.Section.Section;

public class DAOSection implements IDAOSection{
	
	Connection connexion = null;
	
	public DAOSection() {
        try {
            // Initialisation de la connexion à la base de données
            connexion = DriverManager.getConnection("jdbc:postgresql://localhost/", "postgres", "Test01");
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour ajouter une section
    public void addSection(String nom) {
        String sql = "INSERT INTO Section (nom) VALUES (?)";
        try (PreparedStatement insertSection = connexion.prepareStatement(sql)) {
            insertSection.setString(1, nom);
            insertSection.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour mettre à jour une section
    public void updateSection(int id, String nom) {
        String sql = "UPDATE Section SET nom=? WHERE id=?";
        try (PreparedStatement updateSection = connexion.prepareStatement(sql)) {
            updateSection.setString(1, nom);
            updateSection.setInt(2, id);
            updateSection.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour supprimer une section
    public void deleteSection(int id) {
        String sql = "DELETE FROM Section WHERE id=?";
        try (PreparedStatement deleteSection = connexion.prepareStatement(sql)) {
            deleteSection.setInt(1, id);
            deleteSection.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour récupérer l'ID d'une section via son nom
    public int getIDSection(String nom) {
        String sql = "SELECT id FROM Section WHERE nom=?";
        int id = -1;
        try (PreparedStatement getIDSection = connexion.prepareStatement(sql)) {
            getIDSection.setString(1, nom);
            ResultSet resultSet = getIDSection.executeQuery();
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

        }}

    
    public ArrayList<Section> getSectionsContent() {
        ArrayList<Section> liste = new ArrayList<>();
        Statement requete = null;
        ResultSet set = null;

        try {
            // Établir la connexion à la base de données
            connexion = DriverManager.getConnection("jdbc:postgresql://localhost/test", "postgres", "Test01");
            requete = connexion.createStatement();
            
            // Exécuter la requête pour récupérer les noms des sections
            set = requete.executeQuery("SELECT nom FROM Section");
            
            // Parcourir les résultats et ajouter chaque section à la liste
            while (set.next()) {
                Section section = new Section();
                section.setNom(set.getString("nom"));
                liste.add(section);
            }

            // Optionnel : imprimer les sections récupérées pour débogage
            for (Section section : liste) {
                System.out.println("Section: " + section.getNom());
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
            // Optionnel : Fermer la connexion si vous ne prévoyez pas de l'utiliser à nouveau
            // closeConnection();
        }
        return liste;
    }

			
					
		
	
	
	public ArrayList<Section> getSections() {
		ArrayList<Section> liste =new ArrayList<>();
		
		Statement requete = null;
		ResultSet set=null;
		


		
		try {
			connexion = DriverManager.getConnection("jdbc:postgresql://localhost/", "postgres", "Test01");
			
					requete = connexion.createStatement ();
					
			
		try {
			requete.executeUpdate("CREATE DATABASE TEST"); }
			
		catch( SQLException ex) {
				ex.printStackTrace() ;
			}
			
		finally { 
				if (requete != null) {
					try {
						requete.close();
					}
					catch( SQLException ex) {
						ex.printStackTrace() ;
					}
					}
					{
						if (connexion != null) {
							try {
								requete.close();
							}
							catch( SQLException ex) {
								ex.printStackTrace() ;
							}
						}
					}
					connexion = DriverManager.getConnection("jdbc:postgresql://localhost/test", "postgres", "Test01");
					requete = connexion.createStatement();
					
					try {
						requete.executeUpdate("CREATE TABLE Section (id SERIAL PRIMARY KEY, nom VARCHAR(30))" );
										}
					
					catch(SQLException ex) {
						ex.printStackTrace() ;
					}
				set = requete.executeQuery("Select nom FROM Section");
				
				while (set.next()) {
					Section section =new Section();
					section.setNom(set.getString("nom"));
					liste.add(section);
				}
			}
			}
		catch (SQLException ex) {
			ex.printStackTrace() ;
		}
			finally {
				if(set!= null) {
					try {
						set.close();
					}
					catch(SQLException ex) {
						ex.printStackTrace() ;
					}
					
					
					}
				
				}return liste ;
				
				
			}
	
		
	}


