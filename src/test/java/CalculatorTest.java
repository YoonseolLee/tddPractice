import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
	@Test
	void substractTest() {
		int result = Calculator.subtract(10,5);
		assertEquals(5, result);
	}
}
