package miniCalc;

import java.util.Scanner;

public class miniCalc_BeforeRefactoring {

	public static double add(double x, double y) {
		return x + y;
	}

	public static double sub(double x, double y) {
		return x - y;
	}

	public static double multiply(double x, double y) {
		return x * y;
	}

	public static double divide(double x, double y) {
		if (y == 0) {
			System.out.println("0으로 나눌 수 없습니다.");
			return Double.NaN;
		}
		return x / y;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("원하는 연산을 선택하세요.");
		System.out.println("1. 덧셈");
		System.out.println("2. 뺄셈");
		System.out.println("3. 곱셈");
		System.out.println("4. 나눗셈");
		System.out.println("0. 나가기");

		double num1 = 0; // 변수를 밖에서 선언하고 초기화
		double num2 = 0;

		while (true) {
			System.out.print("선택 (1/2/3/4/0): ");
			String choice = scanner.nextLine();

			if (choice.equals("0")) {
				System.out.println("종료합니다.");
				break;
			}

			if (choice.matches("[1-4]")) {
				while (true) {
					try {
						System.out.print("첫 번째 숫자를 입력하세요: ");
						num1 = Double.parseDouble(scanner.nextLine());

						System.out.print("두 번째 숫자를 입력하세요: ");
						num2 = Double.parseDouble(scanner.nextLine());
						break; // 유효한 숫자가 입력되면 반복문 탈출
					} catch (NumberFormatException e) {
						System.out.println("숫자를 입력하세요. 다시 입력하세요.");
					}
				}

				switch (choice) {
					case "1":
						System.out.println(num1 + " + " + num2 + " = " + add(num1, num2));
						break;
					case "2":
						System.out.println(num1 + " - " + num2 + " = " + sub(num1, num2));
						break;
					case "3":
						System.out.println(num1 + " * " + num2 + " = " + multiply(num1, num2));
						break;
					case "4":
						if (num2 != 0) {
							System.out.println(num1 + " / " + num2 + " = " + divide(num1, num2));
						} else {
							System.out.println("0으로 나눌 수 없습니다.");
						}
						break;
				}
			} else {
				System.out.println("잘못된 입력입니다. 다시 입력하세요.");
			}
			System.out.println();
		}
	}
}
