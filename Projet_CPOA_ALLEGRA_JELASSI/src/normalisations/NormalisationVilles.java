package normalisations;

public class NormalisationVilles 
{
	
	public static String ajoutMajuscule(String ville) 
	{
	      char[] arr = ville.toCharArray();
	      arr[0] = Character.toUpperCase(arr[0]);
	      return new String(arr);
	}
	
	public static String AdaptationVilles(String ville)
	{
		ville = ville.trim();
		
		while (ville.contains("  ")) {
			ville = ville.replaceAll("  "," ");
		}
		
		if (ville.contains(" le ")) 
		{
			ville = ville.replaceAll(" le ","-le-");
		}
		
	
		
		if (ville.contains(" lès "))
		{
			ville = ville.replaceAll(" lès ","-lès-");
		}
		

	
		if (ville.contains(" sous "))
		{
			ville = ville.replaceAll(" sous ","-sous-");
		}
		


		if (ville.contains(" sur "))
		{
			ville = ville.replaceAll(" sur ","-sur-");
		}
		


		if (ville.contains(" à "))
		{
			ville = ville.replaceAll(" à ","-à-");
		}
		


		if (ville.contains(" aux "))
		{
			ville = ville.replaceAll(" aux ","-aux-");
		}
		


		if (ville.contains("St ")) 
		{
			ville = ville.replaceAll("St ","Saint-");
		}
		
		if (ville.contains("Ste ")) 
		{
			ville = ville.replaceAll("Ste ", "Sainte-");
		}
		
			return ville;
	}
}
