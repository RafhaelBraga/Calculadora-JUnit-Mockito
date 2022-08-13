package main;

public class Calculadora {

	public float sum(float n1, float n2) {
//		System.out.println("SUM!");
		return n1+n2;
	}
	
	public float sub(float n1, float n2) {
		return n1-n2;
	}
	
	public float div(float n1, float n2) throws Exception{
		if(n2 == 0) {
			throw new Exception("n2 can not be zero.");
		}
		return n1/n2;
	}
	
	public float mult(float n1, float n2) {
		return n1*n2;
	}
	
	public void printSomething() {
		System.out.println("Something");
	}
}