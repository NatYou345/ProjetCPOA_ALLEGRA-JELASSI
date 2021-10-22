/**
 * 
 */
package normalisations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NormalisationPaysTest {

	@Test
	void test() {
		fail("Pas encore implémenté");
	}
	
	void testAjoutMajuscule()
	{
		assertEquals("Metz",NormalisationPays.ajoutMajuscule("metz"));
	}
	
	void testFranciserPays()
	{
		assertEquals("Luxembourg",NormalisationPays.franciserPays("letzebuerg"));
		assertEquals("Belgique",NormalisationPays.franciserPays("belgium"));
		assertEquals("Suisse",NormalisationPays.franciserPays("Switzerland"));
		assertEquals("Suisse",NormalisationPays.franciserPays("Schweiz"));
	}
}