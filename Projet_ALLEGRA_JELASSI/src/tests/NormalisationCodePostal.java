package tests;

public class NormalisationCodePostal {
	
	public static String  NormPostal (String codeP) {
		codeP=codeP.trim();
			
		if ((codeP.length() == 5) && (isNumeric(codeP))) {
			return codeP;
		}
		else if ((codeP.length() == 4) && isNumeric(codeP)) {
			return "0"+ codeP;
			
		}
		else {
			while (!isNumeric(codeP)) {
				codeP= codeP.substring(1);
			}
			return codeP;
		}
	}
	
	
}

