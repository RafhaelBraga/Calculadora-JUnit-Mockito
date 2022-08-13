package main;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
//import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.junit.runners.Parameterized.Parameter;

public class CalculadoraTest {

	private Calculadora calc;
	
//	@Rule
//	public ErrorCollector error = new ErrorCollector();
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setup() {
		calc = new Calculadora();
	}

	@Test
	public void testSum() {
		Assert.assertEquals(3, calc.sum(1, 2), 0.1f);
	}
	
	@Test
	public void testSub() {
		Assert.assertEquals(-1, calc.sub(1, 2), 0.1f);
	}
	
	@Test(expected = Exception.class)
	public void testDiv_DivPorZero() throws Exception{
		//exception.expect(Exception.class);
		Assert.assertEquals(5f, calc.div(1, 0), .1f);
	}
	
	@Test
	public void testDiv() throws Exception{
		Assert.assertEquals(.5f, calc.div(1, 2), .1f);
	}

	@Test
	public void testMult() throws Exception{
		Assert.assertEquals(6, calc.mult(3, 2), .1f);
	}
}
