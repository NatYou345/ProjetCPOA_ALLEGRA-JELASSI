/**
 * 
 */
package modification_BDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Connexion_BDD.Connexion;

public class Periodicite
{
	 private Connexion maConnexion;

	    public Periodicite() 
	    {
	        this.maConnexion=new Connexion();
	    }

	public void requeteAjouterPeriodicite(String libelle) 
	{

		try {
			Connection laConnexion = maConnexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement(" insert into Periodicite (libelle) values (?)"); 
			requete.setString(1, libelle);
			
			int nbPeriodicite = requete.executeUpdate();
			
			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
			
		}catch (SQLException sqle) {
			System.out.println("Problème dans la requête ! " + sqle.getMessage());
		}
	}
	
	public void requeteRetirerPeriodicite(int id_periodicite)
	{

		try {
			Connection laConnexion = maConnexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement(" delete from Periodicite where id_periodicite =?");
			requete.setInt(1, id_periodicite);
			
			int nbPeriodicite = requete.executeUpdate();
			
			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
			
		}catch (SQLException sqle) {
			System.out.println("Problème dans la requête ! " + sqle.getMessage());
		}
	}
	
	public void requeteModifierPeriodicite(int id_periodicite, String libelle)
	{

		try {
			Connection laConnexion = maConnexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement(" update Periodicite SET libelle =? where id_periodicite=?"); 
			requete.setString(1, libelle);
			requete.setInt(2, id_periodicite);
			
			int nbPeriodicite = requete.executeUpdate();
			
			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
			
		}catch (SQLException sqle) {
			System.out.println("Problème dans la requête Update ! " + sqle.getMessage());
		}
	}
}

