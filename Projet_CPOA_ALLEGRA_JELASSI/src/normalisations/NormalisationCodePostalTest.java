package normalisations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NormalisationCodePostalTest {
	
	@Test
	void testIsNumericCasNull()
	{
		assertEquals(false,NormalisationCodePostal.isNumeric(null));
	}
	
	@Test
	void testNormPostal()
	{
		assertEquals("08200",NormalisationCodePostal.NormPostal("8200"));
		assertEquals("2270", NormalisationCodePostal.NormPostal("L-2270"));
	}
}
