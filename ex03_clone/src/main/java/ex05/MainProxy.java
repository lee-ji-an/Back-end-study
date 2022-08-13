package ex05;

public class MainProxy {

	public static void main(String[] args) {
		ExeTimeCalculator cal1 = new ExeTimeCalculator(new ImpCalculator());
		System.out.println(cal1.factorial(10));
		
		ExeTimeCalculator cal2 = new ExeTimeCalculator(new RecCalculator());
		System.out.println(cal2.factorial(10));
	}

}
