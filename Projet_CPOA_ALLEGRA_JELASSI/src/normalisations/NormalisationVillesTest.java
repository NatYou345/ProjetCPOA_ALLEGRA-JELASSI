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
		assertEquals("Vandoeuvre-lès-Nancy",NormalisationVilles.AdaptationVilles("Vandoeuvre  lès  Nancy"));
		assertEquals("Vandoeuvre-sous-Nancy",NormalisationVilles.AdaptationVilles("Vandoeuvre    sous Nancy"));
		assertEquals("Vandoeuvre-sur-Nancy",NormalisationVilles.AdaptationVilles("Vandoeuvre    sur Nancy"));
		assertEquals("Vandoeuvre-à-Nancy",NormalisationVilles.AdaptationVilles("Vandoeuvre à  Nancy"));
		assertEquals("Vandoeuvre-aux-Nancy",NormalisationVilles.AdaptationVilles("Vandoeuvre aux  Nancy"));
		assertEquals("Vandoeuvre Saint-Nancy",NormalisationVilles.AdaptationVilles("Vandoeuvre  St Nancy"));
		assertEquals("Saint-Etienne",NormalisationVilles.AdaptationVilles("St Etienne"));
		assertEquals("Saint-Julien-lès-Metz",NormalisationVilles.AdaptationVilles("St Julien lès Metz"));
		assertEquals("Sainte-Marie-aux-Chênes",NormalisationVilles.AdaptationVilles("Ste Marie aux Chênes"));
		assertEquals("Beuvange-sous-Saint-Michel",NormalisationVilles.AdaptationVilles("Beuvange sous St Michel"));
		
	}

}
