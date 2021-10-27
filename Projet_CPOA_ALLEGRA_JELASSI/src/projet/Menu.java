package projet;

import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import factory.DAOFactory;
import solutionPersistance.Persistance;
import objets_metier.Periodicite;
import objets_metier.Client;
import objets_metier.Abonnement;
import objets_metier.Revue;

/**
 * @author natha
 *
 */
public class Menu {

	/**
	 * @throws ParseException 
	 * 
	 */
	public Menu() throws ParseException {
		String nomcli, nomrevue, descrevue,nomper;
		int idcli, idrevue, idabo, idper;
		DAOFactory daos;
		Client c;
		Periodicite p;
		Revue r;
		Abonnement a;
		Persistance Pers = null;
		Date date_deb;
		
		Scanner sc0 = new Scanner(System.in);
		System.out.println("1 - Solution MYSQL");
		System.out.println("2 - Solution Liste Memoire");
		System.out.println("Votre choix ? ");
		int solution = sc0.nextByte();
		
		switch(solution) {
		case 1:
			Pers = Persistance.MYSQL;
			break;
		
		case 2:
			Pers = Persistance.ListeMemoire;
			break;
		}
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("1 - Gestion des clients");
		System.out.println("2 - Gestion des revues");
		System.out.println("3 - Gestion des periodicites");
		System.out.println("4 - Gestion des abonnements");
		System.out.println("Votre choix ? ");
		int choix = sc1.nextByte();

		System.out.println("1 - Ajouter");
        System.out.println("2 - Modifier");
        System.out.println("3 - Supprimer");
        System.out.println("4 - Afficher");
        int action = sc1.nextByte();
		
		switch(choix){
		   
	       case 1: 
	           switch (action) {
	           case 1:
	        	   Scanner scc1 = new Scanner(System.in);
	        	   System.out.println("Quel est le nom du client ?");
	        	   nomcli =scc1.nextLine();
	        	   daos = DAOFactory.getDAOFactory(Pers);
	        	   c = new Client(-11,nomcli,"","","","","","");
	        	   daos.getClientDAO().create(c);
	        	   
	        	   break;
	           case 2:
	        	   Scanner scc5 = new Scanner(System.in);
	        	   System.out.println("Quel est l'ID du client ?");
	        	   idcli =scc5.nextInt();
	        	   Scanner scc2 = new Scanner(System.in);
	        	   System.out.println("Quel est le nom du client ?");
	        	   nomcli =scc2.nextLine();
	        	   daos = DAOFactory.getDAOFactory(Pers);
	        	   c = new Client(idcli,nomcli,"","","","","","");
	        	   daos.getClientDAO().update(c);
	        	   break;
	           case 3:
	        	   Scanner scc3 = new Scanner(System.in);
	        	   System.out.println("Quel est l'ID du client ?");
	        	   idcli =scc3.nextInt();
	        	   daos = DAOFactory.getDAOFactory(Pers);
	        	   c = new Client(idcli,"","","","","","","");
	        	   daos.getClientDAO().delete(c);
	        	   break;
	           case 4:
	        	   Scanner scc4 = new Scanner(System.in);
	        	   System.out.println("Quel est l'ID du client ?");
	        	   idcli =scc4.nextInt();
	        	   daos = DAOFactory.getDAOFactory(Pers);
	        	   c = daos.getClientDAO().getById(idcli);
	        	   System.out.println(c.toString());
	        	   break;
	           }
	           break;
	   
	       case 2:
	    	   switch (action) {
	    	   case 1:
	        	   Scanner scr1 = new Scanner(System.in);
	        	   System.out.println("Quel est le nom de la revue ?");
	        	   nomrevue =scr1.nextLine();
	        	   System.out.println("Quel est la description de la revue ?");
	        	   descrevue =scr1.nextLine();
	        	   daos = DAOFactory.getDAOFactory(Pers);
	        	   r = new Revue(1,nomrevue,descrevue,0,"",1);
	        	   daos.getRevueDAO().create(r);
	        	   
	        	   break;
	           case 2:
	        	   Scanner scr2 = new Scanner(System.in);
	        	   
	        	   System.out.println("Quel est l'ID de la revue ?");
	        	   idrevue =scr2.nextInt();
	        	   Scanner scr3 = new Scanner(System.in);
	        	   System.out.println("Quel est le nom de la revue ?");
	        	   nomrevue =scr3.nextLine();
	        	   Scanner scr4 = new Scanner(System.in);
	        	   System.out.println("Quel est la description de la revue ?");
	        	   descrevue =scr4.nextLine();
	        	   daos = DAOFactory.getDAOFactory(Pers);
	        	   r = new Revue(1,nomrevue,descrevue,0,"",1);
	        	   daos.getRevueDAO().update(r);
	        	   break;
	           case 3:
	        	   Scanner scr5 = new Scanner(System.in);
	        	   System.out.println("Quel est l'ID de la revue ?");
	        	   idrevue =scr5.nextInt();
	        	   daos = DAOFactory.getDAOFactory(Pers);
	        	   r = new Revue(idrevue,"","",0,"",1);
	        	   daos.getRevueDAO().delete(r);
	        	   break;
	           case 4:
	        	   Scanner scr6 = new Scanner(System.in);
	        	   System.out.println("Quel est l'ID de la revue ?");
	        	   idcli =scr6.nextInt();
	        	   daos = DAOFactory.getDAOFactory(Pers);
	        	   r = daos.getRevueDAO().getById(idcli);
	        	   System.out.println(r.toString());
	        	   break;
	           }
	           break;
	   
	       case 3:
	    	   // Periodicite lignePeriod = new Periodicite();
	    	   switch (action) {
	           case 1:
	        	   Scanner sc2 = new Scanner(System.in);
	        	   System.out.println("Quelle est la p�riodicit� ?");
	        	   nomper = sc2.nextLine();
	        	   daos = DAOFactory.getDAOFactory(Pers);
	        	   Periodicite p1 = new Periodicite(-1,nomper);
	        	   daos.getPeriodiciteDAO().create(p1);
	        	   break;
	           case 2:
	        	   Scanner sc3 = new Scanner(System.in);
	        	   Scanner sc4 = new Scanner(System.in);
	        	   System.out.println("Quel est l'identifiant de la p�riodicit� ?");
	        	   idper =sc3.nextInt();
	        	   System.out.println("Quelle est la p�riodicit� ?");
	        	   nomper = sc4.nextLine();
	        	   daos = DAOFactory.getDAOFactory(Pers);
	        	   Periodicite p2 = new Periodicite(-1,nomper);
	        	   daos.getPeriodiciteDAO().create(p2);
	        	   break;
	           case 3:
	        	   Scanner sc5 = new Scanner(System.in);
	        	   System.out.println("Quel est l'identifiant de la p�riodicit� ?");
	        	   idper =sc5.nextInt();
	        	   DAOFactory daos3 = DAOFactory.getDAOFactory(Pers);
	        	   Periodicite p3 = new Periodicite(1,"");
	        	   daos3.getPeriodiciteDAO().create(p3);
	        	   break;
	           case 4:
	        	   Scanner sc6 = new Scanner(System.in);
	        	   System.out.println("Quel est l'ID de la periodicite ?");
	        	   idper =sc6.nextInt();
	        	   daos = DAOFactory.getDAOFactory(Pers);
	        	   p = daos.getPeriodiciteDAO().getById(idper);
	        	   System.out.println(p.toString());
	        	   break;
	           }
	           break;
	       case 4:
	    	   switch (action) {
	    	   case 1:
	    		   //LocalDate date_deb;
	    		   String sdate_deb;
	        	   Scanner sca1 = new Scanner(System.in);
	        	   System.out.println("Quelle est la date de debut de l'abonnement ?");        	   
	        	   sdate_deb = sca1.nextLine();
	        	   date_deb = new SimpleDateFormat("dd/MM/yyyy").parse(sdate_deb);

	        	   daos = DAOFactory.getDAOFactory(Pers);
	        	   a = new Abonnement(1,date_deb,date_deb,0,1);
	        	   daos.getAbonnementDAO().create(a);
	        	   
	        	   break;
	           case 2:
	        	   Scanner sca2 = new Scanner(System.in);
	        	   System.out.println("Quel est l'ID de l'abonnement ?");
	        	   idabo =sca2.nextInt();
	        	   Scanner sca4 = new Scanner(System.in);
	        	   System.out.println("Quelle est la date de début de l'abonnement ?");        	   
	        	   sdate_deb = sca4.nextLine();
	        	   date_deb = new SimpleDateFormat("dd/MM/yyyy").parse(sdate_deb);
	        	   daos = DAOFactory.getDAOFactory(Pers);
	        	   a = new Abonnement(idabo,date_deb,date_deb,0,1);
	        	   daos.getAbonnementDAO().update(a);
	        	   break;
	           case 3:
	        	   Scanner sca3 = new Scanner(System.in);
	        	   System.out.println("Quel est l'ID de l'abonnement ?");
	        	   idabo =sca3.nextInt();
	        	   daos = DAOFactory.getDAOFactory(Pers);
	        	   a = new Abonnement(idabo);
	        	   daos.getAbonnementDAO().delete(a);
	        	   break;
	           case 4:
	        	   Scanner sca6 = new Scanner(System.in);
	        	   System.out.println("Quel est l'ID de l'abonnement ?");
	        	   idabo =sca6.nextInt();
	        	   daos = DAOFactory.getDAOFactory(Pers);
	        	   a = daos.getAbonnementDAO().getById(idabo);
	        	   System.out.println(a.toString());
	        	   break;
	           }
	           break;
	       default:
	           System.out.println("Choix incorrect ! Veuillez saisir un nombre entre 1 et 4.");
	           break;
	   }
		
		
		
	}

}
