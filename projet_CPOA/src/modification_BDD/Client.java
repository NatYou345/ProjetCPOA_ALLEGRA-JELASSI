/**
 * 
 */
package modification_BDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Connexion_BDD.Connexion;

public class Client
{
	 private Connexion maConnexion;

	    public Client() 
	    {
	        this.maConnexion=new Connexion();
	    }

	public void requeteAjouterClient(int id_client, 
									String nom, 
									String prenom, 
									String no_rue, 
									String voie, 
									String code_postal, 
									String ville,
									String pays) 
	{

		try {
			Connection laConnexion = maConnexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement(" insert into Client (id_client, nom, prenom, no_rue, voie, code_postal, ville, pays) values (?,?,?,?,?,?,?,?)"); 
			requete.setInt(1, id_client);
			requete.setString(2, nom);
			requete.setString(3, prenom);
			requete.setString(4, no_rue);
			requete.setString(5, voie);
			requete.setString(6, code_postal);
			requete.setString(7, ville);
			requete.setString(8, pays);
			
			int nbClient = requete.executeUpdate();
			
			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
			
		}catch (SQLException sqle) {
			System.out.println("Problème dans la requête ! " + sqle.getMessage());
		}
	}
	
	public void requeteRetirerClient(int id_client)
	{

		try {
			Connection laConnexion = maConnexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement(" delete from Client where id_client =?");
			requete.setInt(1, id_client);
			
			int nbClient = requete.executeUpdate();
			
			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
			
		}catch (SQLException sqle) {
			System.out.println("Problème dans la requête ! " + sqle.getMessage());
		}
	}
	
	public void requeteModifierClient(int id_client, 
										String nom, 
										String prenom, 
										String no_rue, 
										String voie, 
										String code_postal, 
										String ville,
										String pays)
	{

		try {
			Connection laConnexion = maConnexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement(" update Client SET libelle =? where id_client=?"); 
			requete.setInt(1, id_client);
			requete.setString(2, nom);
			requete.setString(3, prenom);
			requete.setString(4, no_rue);
			requete.setString(5, voie);
			requete.setString(6, code_postal);
			requete.setString(7, ville);
			requete.setString(8, pays);

			
			int nbClient = requete.executeUpdate();
			
			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
			
		}catch (SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
		}
	}
}
