package main;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalculadoraMockitoTest {
	
	@Mock Calculadora mockCalc;

	@Spy private Calculadora spyCalc;
	
	@Test
	public void demonstrateMockCalc() {
		
		//nessa situa��o, retorna 40
		Mockito.when(mockCalc.sum(2, 2)).thenReturn(40f);
		
		//nessa situa��o, chama o m�todo real
		Mockito.when(mockCalc.sum(1, 2)).thenCallRealMethod();
		
		System.out.println("mock: \n"+mockCalc.sum(2,2)); //retorno ensindo, 40
		System.out.println(mockCalc.sum(1,2)); //retorno do m�todo real, 3
		System.out.println(mockCalc.sum(1,3)); //retorno padr�o, para float, 0.0

		mockCalc.printSomething();

	}
	
	@Test
	public void demonstrateSpyCalc() {		

		//nessa situa��o, retorna 40
		//vale observar que o sum � executado no momento em que o mockito est� gravando
		//o comportamento, basta descomentar o print no m�todo
		Mockito.when(spyCalc.sum(2, 2)).thenReturn(40f);
		//para evitar o problema, podemos substituir por:
		//Mockito.doReturn(40f).when(spyCalc).sum(2, 2);
		
		//define o comportamento dentro de demonstrateSpyCalc para printSomething
		//que tem retorno void, caso contr�rio o m�todo seria executado normalmente
		Mockito.doNothing().when(spyCalc).printSomething();
		
		System.out.println("\n\nspy:\n"+spyCalc.sum(2,2));//retorno ensindo, 40
		System.out.println(spyCalc.sum(1,2));//retorno do m�todo real, 3
		System.out.println(spyCalc.sum(1,3));//retorno do m�todo real, 4
		
		spyCalc.printSomething();
	}
	
	
}
