package miniCalc.afterRefactoring;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 계산 인터페이스
interface Operation {
	double apply(double x, double y);
}

// 계산기 클래스
class MiniCalc_Refactored {
	public double calculate(double x, double y, Operation operation) {
		return operation.apply(x, y);
	}

	public double add(double x, double y) {
		return x + y;
	}

	public double subtract(double x, double y) {
		return x - y;
	}

	public double multiply(double x, double y) {
		return x * y;
	}

	public double divide(double x, double y) {
		if (y == 0) {
			throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
		}
		return x / y;
	}
}

// 사용자 인터페이스 클래스
class UserInterface {
	private final MiniCalc_Refactored calculator;
	private final Scanner scanner;
	private final Map<String, Operation> operations;

	public UserInterface(MiniCalc_Refactored calculator, Scanner scanner) {
		this.calculator = calculator;
		this.scanner = scanner;
		this.operations = new HashMap<>();
		operations.put("1", calculator::add);
		operations.put("2", calculator::subtract);
		operations.put("3", calculator::multiply);
		operations.put("4", calculator::divide);
	}

	public void start() {
		System.out.println("원하는 연산을 선택하세요.");
		System.out.println("1. 덧셈");
		System.out.println("2. 뺄셈");
		System.out.println("3. 곱셈");
		System.out.println("4. 나눗셈");
		System.out.println("0. 나가기");

		while (true) {
			System.out.print("선택 (1/2/3/4/0): ");
			String choice = scanner.nextLine();

			if (choice.equals("0")) {
				System.out.println("종료합니다.");
				break;
			}

			if (operations.containsKey(choice)) {
				try {
					System.out.print("첫 번째 숫자를 입력하세요: ");
					double num1 = Double.parseDouble(scanner.nextLine());

					System.out.print("두 번째 숫자를 입력하세요: ");
					double num2 = Double.parseDouble(scanner.nextLine());

					double result = calculator.calculate(num1, num2, operations.get(choice));
					System.out.println(num1 + " " + choice + " " + num2 + " = " + result);
				} catch (NumberFormatException e) {
					System.out.println("숫자를 입력하세요. 다시 입력하세요.");
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
			} else {
				System.out.println("잘못된 입력입니다. 다시 입력하세요.");
			}
			System.out.println();
		}
	}
}

public class MiniCalc_RefactoredApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MiniCalc_Refactored calculator = new MiniCalc_Refactored();
		UserInterface userInterface = new UserInterface(calculator, scanner);

		userInterface.start();
	}
}
