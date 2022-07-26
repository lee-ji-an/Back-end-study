package ex05;

public class RecCalculator implements Calculator {

	@Override
	public long factorial(long num) {
		// TODO Auto-generated method stub
		if(num == 0)
			return 1;
		return num * factorial(num-1);
	}
}
