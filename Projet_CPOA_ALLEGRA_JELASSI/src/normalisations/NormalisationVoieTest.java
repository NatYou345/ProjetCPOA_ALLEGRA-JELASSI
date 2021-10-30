package normalisations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NormalisationVoieTest {
	
	@Test
	void testAdaptationVoie() 
	{
		assertEquals("boulevard de la Vilette",NormalisationVoie.AdaptationVoie("boul de la Vilette"));
		assertEquals("boulevard de la Vilette",NormalisationVoie.AdaptationVoie("boul. de la Vilette"));
		assertEquals("boulevard de la Vilette",NormalisationVoie.AdaptationVoie("bd de la Vilette"));
		assertEquals("avenue de la Vilette",NormalisationVoie.AdaptationVoie("av. de la Vilette"));
		assertEquals("faubourg de la Vilette",NormalisationVoie.AdaptationVoie("faub. de la Vilette"));
		assertEquals("faubourg de la Vilette",NormalisationVoie.AdaptationVoie("fg de la Vilette"));
		assertEquals("place de la Vilette",NormalisationVoie.AdaptationVoie("pl. de la Vilette"));
	}

}
