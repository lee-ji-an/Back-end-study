package ex05;

public class MainProxy {

	public static void main(String[] args) {
		ExeTimeCalculator call = new ExeTimeCalculator(new ImpCalculator());
		System.out.println(call.factorial(100));
		
		ExeTimeCalculator call2 = new ExeTimeCalculator(new RecCalculator());
		System.out.println(call2.factorial(100));
		
	}
}
