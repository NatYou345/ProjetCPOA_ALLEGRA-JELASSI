package modification_BDD;

import java.util.Scanner;

/**
 * @author natha
 *
 */
public class Menu {

	/**
	 * 
	 */
	public Menu() {
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
	        	   
	        	   break;
	           case 2:
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
	    	   Periodicite lignePeriod = new Periodicite();
	    	   switch (action) {
	           case 1:
	        	   Scanner sc2 = new Scanner(System.in);
	        	   System.out.println("Quelle est la périodicité ?");
	        	   String period1 =sc2.nextLine();
	        	   lignePeriod.requeteAjouterPeriodicite(period1);
	        	   break;
	           case 2:
	        	   Scanner sc3 = new Scanner(System.in);
	        	   Scanner sc4 = new Scanner(System.in);
	        	   System.out.println("Quel est l'identifiant de la périodicité ?");
	        	   int idModif =sc3.nextInt();
	        	   System.out.println("Quelle est la périodicité ?");
	        	   String period2 = sc4.nextLine();
	        	   lignePeriod.requeteModifierPeriodicite(idModif, period2);
	        	   break;
	           case 3:
	        	   Scanner sc5 = new Scanner(System.in);
	        	   System.out.println("Quel est l'identifiant de la périodicité ?");
	        	   int idDelete =sc5.nextInt();
	        	   lignePeriod.requeteRetirerPeriodicite(idDelete);
	        	   break;
	           }
	           break;
	           
	       default:
	           System.out.println("Choix incorrect ! Veuillez saisir un nombre entre 1 et 4.");
	           break;
	   }
		
		
		
	}

}
