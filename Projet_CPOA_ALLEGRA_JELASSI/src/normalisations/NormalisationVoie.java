package normalisations;


	public class NormalisationVoie {
		
	public static String normVoie(String NomVoie) {
		
		NomVoie=NomVoie.trim();
        switch(NomVoie){

           case "boul" : case "boul." : case "bd" : 
               return "Boulevard";
           case "av." : 
               return "avenue";
           case "faub." : case "fg" :
               return "faubourg";
           case "pl." : 
               return "place";
           default: return NomVoie;
       }	
	}
}

