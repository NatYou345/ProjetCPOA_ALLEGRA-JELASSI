package normalisations;

public class NormalisationPays {
	public static String ajoutMajuscule(String pays) {
	      char[] arr = pays.toCharArray();
	      arr[0] = Character.toUpperCase(arr[0]);
	      return new String(arr);
	   }
	public static String franciserPays (String result) {
	   result = result.replaceAll("\\s+","");
	    switch (result) {
	    case "letzebuerg":
	    	result="Luxembourg";
	           break;
	    case "belgium":
	    	result="Belgique";
	           break;
	    case "Switzerland":
	    	result="Suisse";
	           break;
	    case "Schweiz":
	    	result="Suisse";
	           break;
	       default:
	           result=ajoutMajuscule(result);
	           break;
	          
	    }
	    return result;
	}
	}