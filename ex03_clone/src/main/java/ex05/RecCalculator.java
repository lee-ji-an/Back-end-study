package ex05;

public class RecCalculator implements Calculator {
	
	// 재귀 함수로 factorial 계산
	@Override
	public long factorial(long num) {
		if (num == 1)
			return 1;
		return num * factorial(num - 1);
	}
}
