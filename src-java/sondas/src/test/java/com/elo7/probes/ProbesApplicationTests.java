package com.elo7.probes;

import org.springframework.boot.test.context.SpringBootTest;


/**
 * Class to perform unitary tests on methods of class SondaService.
 */
@SpringBootTest
class ProbesApplicationTests {
	//private SondaService service = new SondaService();

	/**
	 * Tests the setting of the maximum x and y coordinates of the Planalto.
	 */
	/*@Test
	public void testSetPlanalto() {
		int max_x = 10;
		int max_y = 10;

		service.setPlanalto(max_x, max_y);

		// Verifies that the maximum x-coordinate of the Planalto is corret.
		assertEquals(max_x, Planalto.max_x);
		// Verifies that the maximum y-coordinate of the Planalto is corret.
		assertEquals(max_y, Planalto.max_y);
	}*/

	/**
	 * Tests that indeed a sonda object is added to the list sondas when the
	 * method save of SondaService is used.
	 */
	/*@Test
	public void testSaveSonda() {
		Sonda sonda = new Sonda(0, 0, 'N');
		String instructions = new String("MMM");

		Sonda s = service.save(sonda, instructions);

		// Verifies that an object was returned
		assertNotNull(s);

		// Verifies if the sonda was added in the list sondas
		List<Sonda> sondas = service.getSondas();
		assertTrue(sondas.contains(s));
	}*/

	/**
	 * Tests if the instructions were correctly performed in the Sonda object
	 * when using method save of SondaService
	 */
	/*@Test
	public void test1Instructions() {
		Sonda sonda = new Sonda(1, 2, 'N');
		String instructions = new String("LMLMLMLMM");

		Sonda s = service.save(sonda, instructions);

		// Verifies the final position of the sonda after the instructions
		assertEquals("1 3 N",
				s.getX() + " " + s.getY() + " " + s.getDirection());
	}*/

	/**
	 * Tests if the instructions were correctly performed in the Sonda object
	 * when using method save of SondaService
	 */
	/*@Test
	public void test2Instructions() {
		Sonda sonda = new Sonda(3, 3, 'E');
		String instructions = new String("MMRMMRMRRM");

		Sonda s = service.save(sonda, instructions);

		assertEquals("5 1 E",
				s.getX() + " " + s.getY() + " " + s.getDirection());
	}*/
}
