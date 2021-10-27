package modification_BDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.MySQL.Connexion;

public class Revue
{
	 private Connexion maConnexion;

	    public Revue() 
	    {
	        this.maConnexion=new Connexion();
	    }

	public void requeteAjouterRevue(String titre, String description,Integer tarif_numero,String visuel, Integer id_periodicite) 
	{

		try {
			Connection laConnexion = maConnexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement(" insert into Revue (titre,description,tarif_numero,visuel,id_periodicite) values (?,?,?,?,?)"); 
			requete.setString(1, titre);
			requete.setString(2, description);
			requete.setInt(3, tarif_numero);
			requete.setString(4, visuel);
			requete.setInt(5,id_periodicite );
			
			int nbPeriodicite = requete.executeUpdate();
			
			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
			
		}catch (SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
		}
	}
	
	public void requeteRetirerRevue(Integer id_revue)
	{

		try {
			Connection laConnexion = maConnexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement(" delete from Revue where id_revue =?");
			requete.setInt(1, id_revue);
			
			int nbPeriodicite = requete.executeUpdate();
			
			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
			
		}catch (SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
		}
	}
	
	public void requeteModifierRevue(Integer id_revue,String titre, String description,Integer tarif_numero,String visuel, Integer id_periodicite)
	{

		try {
			Connection laConnexion = maConnexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement(" update Revue SET titre =?,description=?,tarif_numero=?,visuel=?,id_periodicite=? where id_revue=?"); 
			requete.setString(1, titre);
			requete.setString(2, description);
			requete.setInt(3,tarif_numero);
			requete.setString(4, visuel);
			requete.setInt(5, id_periodicite);
			requete.setInt(6, id_revue);
			
			int nbPeriodicite = requete.executeUpdate();
			
			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
			
		}catch (SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
		}
	}
}
