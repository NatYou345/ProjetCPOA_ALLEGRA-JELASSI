package normalisations;

public class NormalisationCodePostal {
	
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) 
	    {
	        return false;
	    }
	    try {
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}

	public static String NormPostal (String i) {
		i=i.trim();
			
		if ((i.length() == 5) && (isNumeric(i))) 
		{
			return i;
		}
		else if ((i.length() == 4) && isNumeric(i)) 
		{

			return ("0"+i);
			
		}
		else {
			i= i.substring(2);
			return i;
		}
	}	
}

