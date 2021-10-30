package normalisations;


	public class NormalisationVoie {
		
		public static String AdaptationVoie(String voie)
		{
			voie = voie.trim();
			
			while (voie.contains("  ")) {
				voie = voie.replaceAll("  "," ");
			}
			
			if (voie.contains("boul. ")) 
			{
				voie = voie.replaceAll("boul. ","boulevard ");
			}
			
		
			
			if (voie.contains("boul "))
			{
				voie = voie.replaceAll("boul ","boulevard ");
			}
			

		
			if (voie.contains("bd "))
			{
				voie = voie.replaceAll("bd ","boulevard ");
			}
			


			if (voie.contains("av. "))
			{
				voie = voie.replaceAll("av. ","avenue ");
			}
			


			if (voie.contains("faub. "))
			{
				voie = voie.replaceAll("faub. ","faubourg ");
			}
			


			if (voie.contains("fg "))
			{
				voie = voie.replaceAll("fg ","faubourg ");
			}
			


			if (voie.contains("pl. ")) 
			{
				voie = voie.replaceAll("pl. ","place ");
			}
			
			
				return voie;
		}
}

