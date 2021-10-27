package normalisations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NormalisationVillesTest {
	
	@Test
	void testAjoutMajuscule() 
	{
		assertEquals("Metz",NormalisationVilles.ajoutMajuscule("metz"));
	}
	
	@Test
	void testAdaptationVilles() 
	{
		assertEquals("Norroy-le-Veneur",NormalisationVilles.AdaptationVilles("Norroy      le    Veneur"));
		assertEquals("Vandoeuvre-l�s-Nancy",NormalisationVilles.AdaptationVilles("Vandoeuvre  l�s  Nancy"));
		assertEquals("Vandoeuvre-sous-Nancy",NormalisationVilles.AdaptationVilles("Vandoeuvre    sous Nancy"));
		assertEquals("Vandoeuvre-sur-Nancy",NormalisationVilles.AdaptationVilles("Vandoeuvre    sur Nancy"));
		assertEquals("Vandoeuvre-�-Nancy",NormalisationVilles.AdaptationVilles("Vandoeuvre �  Nancy"));
		assertEquals("Vandoeuvre-aux-Nancy",NormalisationVilles.AdaptationVilles("Vandoeuvre aux  Nancy"));
		assertEquals("Vandoeuvre Saint-Nancy",NormalisationVilles.AdaptationVilles("Vandoeuvre  St Nancy"));
		assertEquals("Saint-Etienne",NormalisationVilles.AdaptationVilles("St Etienne"));
		assertEquals("Saint-Julien-l�s-Metz",NormalisationVilles.AdaptationVilles("St Julien l�s Metz"));
		assertEquals("Sainte-Marie-aux-Ch�nes",NormalisationVilles.AdaptationVilles("Ste Marie aux Ch�nes"));
		assertEquals("Beuvange-sous-Saint-Michel",NormalisationVilles.AdaptationVilles("Beuvange sous St Michel"));
		
	}

}
