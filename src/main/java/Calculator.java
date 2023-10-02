public class Calculator {
	public static int subtract(int a, int b) {
		int answer = a - b;
		return answer;
	}

	public static void main(String[] args) {
		int answer = Calculator.subtract(100,1);
		System.out.println(answer);
	}
}
