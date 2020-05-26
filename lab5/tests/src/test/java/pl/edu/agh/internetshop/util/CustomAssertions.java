package pl.edu.agh.internetshop.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

public class CustomAssertions {

	/**
	 * Asserts if two give BigDecimals have equal <b>numeric value</b>, ignoring
	 * scale, which is by default used in {@link BigDecimal#equals(Object)}
	 * method.
	 * 
	 * @param a
	 *            expected value
	 * @param b
	 *            actual value
	 */
	public static void assertBigDecimalCompareValue(BigDecimal a, BigDecimal b) {
		assertEquals(a.compareTo(b), 0);
	}
}
