package com.elo7.sondas;

import com.elo7.sondas.domain.Planalto;
import com.elo7.sondas.domain.Sonda;
import com.elo7.sondas.domain.SondaService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class SondasApplicationTests {

	private SondaService service = new SondaService();

	@Test
	public void testSavePlanalto() {
		int max_x = 10;
		int max_y = 10;

		service.setPlanalto(max_x, max_y);

		// Verifica que coordenada do ponto superior-direito da malha do
		// planalto foi assinalada corretamente
		assertEquals(max_x, Planalto.max_x);
		assertEquals(max_y, Planalto.max_y);
	}

	@Test
	public void testSaveSonda() {
		Sonda sonda = new Sonda(0, 0, 'N');
		String instructions = new String("MMM");

		Sonda s = service.save(sonda, instructions);

		// Verifica que foi retornado um objeto
		assertNotNull(s);

		// Verifica se a sonda foi adicionada
		List<Sonda> sondas = service.getSondas();
		assertTrue(sondas.contains(s));
	}

	@Test
	public void test1Instructions() {
		Sonda sonda = new Sonda(1, 2, 'N');
		String instructions = new String("LMLMLMLMM");

		Sonda s = service.save(sonda, instructions);

		// Verifica a posição final da sonda após as instruções
		assertEquals("1 3 N",
				s.getX() + " " + s.getY() + " " + s.getDirection());
	}

	@Test
	public void test2Instructions() {
		Sonda sonda = new Sonda(3, 3, 'E');
		String instructions = new String("MMRMMRMRRM");

		Sonda s = service.save(sonda, instructions);

		// Verifica a posição final da sonda após as instruções
		assertEquals("5 1 E",
				s.getX() + " " + s.getY() + " " + s.getDirection());
	}
}
