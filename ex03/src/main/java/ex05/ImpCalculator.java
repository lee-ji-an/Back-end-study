package ex05;

public class ImpCalculator implements Calculator {

	@Override
	public long factorial(long num) {
		long start = System.currentTimeMillis();
		long result = 1;
		for (long i = 1; i<=num; i++) {
			result *= i;
		}
		long end = System.currentTimeMillis();
		System.out.printf("ImCalculator.factorial (%d) 실행 시간 = %d\n", num, (end-start));
		return result;
	}
	
	public static void main(String[] args) {
		ImpCalculator c = new ImpCalculator();
		c.factorial(1000);
		c.factorial(100000000);
	}

}
