package projet;

import java.util.Scanner;

import Factory.DAOFactory;
import solutionPersistance.Persistance;
import objets_métier.Periodicite;

/**
 * @author natha
 *
 */
public class Menu {

	/**
	 * 
	 */
	public Menu() {
		Scanner sc0 = new Scanner(System.in);
		System.out.println("1 - Sauvegarde dans MYSQL");
		System.out.println("2 - Sauvegarde dans Liste Mémoire");
		System.out.println("Votre choix ? ");
		int solution = sc0.nextInt();
		DAOFactory daos;
		if (solution == 1) {
			  //daos = DAOFactory.getDAOFactory(Persistance.MYSQL);
		}
		else {
			  //daos = DAOFactory.getDAOFactory(Persistance.ListeMemoire);
		};
				
		Scanner sc1 = new Scanner(System.in);
		System.out.println("1 - Gestion des clients");
		System.out.println("2 - Gestion des revues");
		System.out.println("3 - Gestion des périodicités");
		System.out.println("4 - Gestion des abonnements");
		System.out.println("Votre choix ? ");
		int choix = sc1.nextByte();
		
		System.out.println("1 - Ajouter");
        System.out.println("2 - Modifier");
        System.out.println("3 - Supprimer");
        int action = sc1.nextByte();
		
		
		switch(choix){
		   
	       case 1: 
	           switch (action) {
	           case 1:
	        	   Scanner sc = new Scanner(System.in);
	        	   System.out.println("Nom du client ?");
	        	   String nomcli =sc.nextLine();
	        	   daos = DAOFactory.getDAOFactory(Persistance.MYSQL);
	        	   Client c = new Client(1,nomcli);
	        	   daos.getClientDAO().create(c);
	        	   //lignePeriod.requeteAjouterPeriodicite(period1);
	        	   break;
	           case 2:
	        	   Scanner sc = new Scanner(System.in);
	        	   System.out.println("Id du client ?");
	        	   String id_cli =sc.nextInt();
	        	   Scanner sc = new Scanner(System.in);
	        	   System.out.println("Nom du client ?");
	        	   String nomcli =sc.nextLine();

	        	   break;
	           case 3:
	        	   break;
	           }
	           break;
	   
	       case 2:
	    	   switch (action) {
	           case 1:
	        	   break;
	           case 2:
	        	   break;
	           case 3:
	        	   break;
	           }
	           break;
	   
	       case 3:
	    	   // Periodicite lignePeriod = new Periodicite();
	    	   switch (action) {
	           case 1:
	        	   Scanner sc2 = new Scanner(System.in);
	        	   System.out.println("Quelle est la périodicité ?");
	        	   String period1 =sc2.nextLine();
	        	   daos = DAOFactory.getDAOFactory(Persistance.MYSQL);
	        	   Periodicite p = new Periodicite(1,period1);
	        	   daos.getPeriodiciteDAO().create(p);
	        	   //lignePeriod.requeteAjouterPeriodicite(period1);
	        	   break;
	           case 2:
	        	   Scanner sc3 = new Scanner(System.in);
	        	   Scanner sc4 = new Scanner(System.in);
	        	   System.out.println("Quel est l'identifiant de la périodicité ?");
	        	   int idModif =sc3.nextInt();
	        	   System.out.println("Quelle est la périodicité ?");
	        	   String period2 = sc4.nextLine();
	        	   //DAOFactory daos2 = DAOFactory.getDAOFactory(Persistance.MYSQL);
	        	   Periodicite p2 = new Periodicite(1,period2);
	        	   //daos2.getPeriodiciteDAO().create(p2);
	        	   //lignePeriod.requeteModifierPeriodicite(idModif, period2);
	        	   break;
	           case 3:
	        	   Scanner sc5 = new Scanner(System.in);
	        	   System.out.println("Quel est l'identifiant de la périodicité ?");
	        	   String idDelete =sc5.nextLine();
	        	   //DAOFactory daos3 = DAOFactory.getDAOFactory(Persistance.MYSQL);
	        	   Periodicite p3 = new Periodicite(1,idDelete);
	        	   //daos3.getPeriodiciteDAO().create(p3);
	        	   //lignePeriod.requeteRetirerPeriodicite(idDelete);
	        	   break;
	           }
	           break;
	           
	       default:
	           System.out.println("Choix incorrect ! Veuillez saisir un nombre entre 1 et 4.");
	           break;
	   }
		
		
		
	}

}
