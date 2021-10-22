package normalisations;

public class NormalisationVilles 
{
	public static String ajoutMajuscule(String ville) 
	{
	      char[] arr = ville.toCharArray();
	      arr[0] = Character.toUpperCase(arr[0]);
	      return new String(arr);
	}
	
	public static String TiretPreposition(String ville)
	{
		ville = ville.replaceAll("\\s+","");
		if (ville.contains(" le "))
		{
		return("-le-");
		}

		else if (ville.contains(" lès "))
		{
		return("-lès-");
		}
		
		else if (ville.contains(" sous "))
		{
		return("-sous-");
		}
		
		else if (ville.contains(" sur "))
		{
		return("-sur-");
		}
		
		else if (ville.contains(" à "))
		{
		return("-à-");
		}
		
		else if (ville.contains(" aux "))
		{
		return("-aux-");
		}
		
		if (ville.contains("St")) 
		{
			return("Saint-");
		}
		
		if (ville.contains("Ste")) 
		{
			return("Sainte-");
		}
		
		else
			return ville;
	}
}
