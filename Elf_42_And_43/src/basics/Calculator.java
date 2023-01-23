package basics;

public class Calculator {

	public int add(int...add) {
		int sum = 0;
		for(int a : add) {
			sum = sum + a;
		}
		return sum;		
	}
	
	public int sub(int a, int b) {
		return a-b;
	}
	
	public int mult(int a, int b) {
		return a*b;
	}
	
	public int div(int a, int b) {
		return a/b;
	}
}
