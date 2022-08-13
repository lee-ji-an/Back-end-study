package ex05;

public class ExeTimeCalculator implements Calculator {

	private Calculator delegate;
	
	// 생성자의 인자로 대상 객체가 전달됨
	public ExeTimeCalculator(Calculator delegate) {	
		this.delegate = delegate;
	}
	
	@Override
	public long factorial(long num) {
		long start = System.nanoTime();
		long result = delegate.factorial(num); 	//프록시 객체가 대상 객체를 대신 실행
		long end = System.nanoTime();

		System.out.printf("%s.factorial(%d) 실행시간 = %d\n",
				delegate.getClass().getSimpleName(), num, (end-start));
		
		return result;
	}
}
