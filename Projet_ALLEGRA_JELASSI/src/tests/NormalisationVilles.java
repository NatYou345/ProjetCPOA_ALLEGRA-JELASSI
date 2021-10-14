package tests;

public class NormalisationVilles {
	public static String upperCaseFirst(String ville) {
	      char[] arr = ville.toCharArray();
	      arr[0] = Character.toUpperCase(arr[0]);
	      return new String(arr);
			   
		   }
	}
