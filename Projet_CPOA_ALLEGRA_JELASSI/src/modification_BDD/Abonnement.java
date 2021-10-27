/**
 * 
 */
package modification_BDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dao.MySQL.Connexion;

public class Abonnement
{
	 private Connexion maConnexion;

	    public Abonnement() 
	    {
	        this.maConnexion=new Connexion();
	    }

	public void requeteAjouterAbonnement(int id_abonnement, 
									String date_debut,
									String date_fin,
									int id_client, 
									int id_revue) 
	{

		try {
			Connection laConnexion = maConnexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement(" insert into Abonnement (id_abonnement, date_debut,date_fin,id_client,id_revue) values (?,?,?,?,?)"); 
			requete.setInt(1, id_abonnement);
			
			requete.setDate(2, java.sql.Date.valueOf(date_debut));
			requete.setDate(3, java.sql.Date.valueOf(date_fin));
			requete.setInt(4, id_client);
			requete.setInt(5, id_revue);

			int nbAbonnement = requete.executeUpdate();
			
			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
			
		}catch (SQLException sqle) {
			System.out.println("Problème dans la requête ! " + sqle.getMessage());
		}
	}
	
	public void requeteRetirerAbonnement(int id_abonnement)
	{

		try {
			Connection laConnexion = maConnexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement(" delete from Abonnement where id_abonnement =?");
			requete.setInt(1, id_abonnement);
			
			int nbAbonnement = requete.executeUpdate();
			
			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
			
		}catch (SQLException sqle) {
			System.out.println("Problème dans la requête ! " + sqle.getMessage());
		}
	}
	
	public void requeteModifierAbonnement(int id_abonnement, 
											String date_debut,
											String date_fin,
											int id_client, 
											int id_revue)
	{

		try {
			Connection laConnexion = maConnexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement(" update Client SET date_debut =?, date_fin =?, id_client =?, id_revue =? where id_abonnement =?"); 
			requete.setDate(1, java.sql.Date.valueOf(date_debut));
			requete.setDate(2, java.sql.Date.valueOf(date_fin));
			requete.setInt(3, id_client);
			requete.setInt(4, id_revue);

			
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
