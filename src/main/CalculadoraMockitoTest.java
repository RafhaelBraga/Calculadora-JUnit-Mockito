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
		
		//nessa situação, retorna 40
		Mockito.when(mockCalc.sum(2, 2)).thenReturn(40f);
		
		//nessa situação, chama o método real
		Mockito.when(mockCalc.sum(1, 2)).thenCallRealMethod();
		
		System.out.println("mock: \n"+mockCalc.sum(2,2)); //retorno ensindo, 40
		System.out.println(mockCalc.sum(1,2)); //retorno do método real, 3
		System.out.println(mockCalc.sum(1,3)); //retorno padrão, para float, 0.0

		mockCalc.printSomething();

	}
	
	@Test
	public void demonstrateSpyCalc() {		

		//nessa situação, retorna 40
		//vale observar que o sum é executado no momento em que o mockito está gravando
		//o comportamento, basta descomentar o print no método
		Mockito.when(spyCalc.sum(2, 2)).thenReturn(40f);
		//para evitar o problema, podemos substituir por:
		//Mockito.doReturn(40f).when(spyCalc).sum(2, 2);
		
		//define o comportamento dentro de demonstrateSpyCalc para printSomething
		//que tem retorno void, caso contrário o método seria executado normalmente
		Mockito.doNothing().when(spyCalc).printSomething();
		
		System.out.println("\n\nspy:\n"+spyCalc.sum(2,2));//retorno ensindo, 40
		System.out.println(spyCalc.sum(1,2));//retorno do método real, 3
		System.out.println(spyCalc.sum(1,3));//retorno do método real, 4
		
		spyCalc.printSomething();
	}
	
	
}
