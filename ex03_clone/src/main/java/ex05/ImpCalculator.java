package ex05;

public class ImpCalculator implements Calculator{
	// 반복문으로 factorial 계산
	@Override
	public long factorial(long num) {
		//메서드의 시작시간 저장
//		long start = System.currentTimeMillis();
		long result = 1;
		for (long i = 1; i <= num; i++) {
			result *= i;
		}
		//메서드의 종료시간 저장
//		long end = System.currentTimeMillis();
//		System.out.printf("ImpCalculator.factorial(%d) 실행 시간 = %d\n", num, (end-start));	
		return result;
	}

//	public static void main(String[] args) {
//	ImpCalculator c = new ImpCalculator();
//	c.factorial(100000000);		//	75ms
//}
}
