package ex05;

public class MainCalculator {

	public static void main(String[] args) {
		long num = 100;
		
		ImpCalculator impCal = new ImpCalculator();
		long start1 = System.currentTimeMillis();
		impCal.factorial(num);
		long end1 = System.currentTimeMillis();
		System.out.printf("ImpCalculator.factorial(%d) 실행 시간 = %d\n", num, (end1 - start1));

		RecCalculator recCal = new RecCalculator();
		long start2 = System.currentTimeMillis();
		recCal.factorial(num);
		long end2 = System.currentTimeMillis();
		System.out.printf("RecCalculator.factorial(%d) 실행 시간 = %d\n", num, (end2 - start2));
	}
}

