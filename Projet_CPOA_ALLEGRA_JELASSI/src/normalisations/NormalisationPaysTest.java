package normalisations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NormalisationPaysTest {
	
	@Test
	void testAjoutMajuscule()
	{
		assertEquals("France",NormalisationPays.ajoutMajuscule("france"));
	}
	
	@Test
	void testFranciserPays()
	{
		assertEquals("Luxembourg",NormalisationPays.franciserPays("letzebuerg"));
		assertEquals("Belgique",NormalisationPays.franciserPays("belgium"));
		assertEquals("Suisse",NormalisationPays.franciserPays("Switzerland"));
		assertEquals("Suisse",NormalisationPays.franciserPays("Schweiz"));
	}
}