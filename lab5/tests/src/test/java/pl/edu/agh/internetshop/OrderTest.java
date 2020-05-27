package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static pl.edu.agh.internetshop.util.CustomAssertions.assertBigDecimalCompareValue;

public class OrderTest {

	private Order getOrderWithMockedProduct() {
		Product product = mock(Product.class);
		return new Order(Collections.singletonList(product));
	}

	@Test
	public void testGetProductThroughOrder() {
		// given
		Product expectedProduct = mock(Product.class);
		Order order = new Order(Collections.singletonList(expectedProduct));

		// when
		List<Product> actualProduct = order.getProducts();

		// then
		assertSame(expectedProduct, actualProduct.get(0));
	}

	@Test
	public void testGetMultipleProductsThroughOrder() {
		// given
		Product expectedProduct1 = mock(Product.class);
		Product expectedProduct2 = mock(Product.class);
		Product expectedProduct3 = mock(Product.class);
		Order order = new Order(Arrays.asList(expectedProduct1, expectedProduct2, expectedProduct3));

		//when
		List<Product> products = order.getProducts();

		//then
		assertEquals(3, products.size());
		assertEquals(expectedProduct1, products.get(0));
		assertEquals(expectedProduct2, products.get(1));
		assertEquals(expectedProduct3, products.get(2));
	}

	@Test
	public void testSetProductsAsNullInOrder() {
		//given,when,then
		assertThrows(NullPointerException.class, () -> new Order(null));
	}

	@Test
	public void testSetShipment() throws Exception {
		// given
		Order order = getOrderWithMockedProduct();
		Shipment expectedShipment = mock(Shipment.class);

		// when
		order.setShipment(expectedShipment);

		// then
		assertSame(expectedShipment, order.getShipment());
	}

	@Test
	public void testShipmentWithoutSetting() throws Exception {
		// given
		Order order = getOrderWithMockedProduct();

		// when

		// then
		assertNull(order.getShipment());
	}

	@Test
	public void testGetPrice() throws Exception {
		// given
		BigDecimal expectedProductPrice = BigDecimal.valueOf(1000);
		Product product = mock(Product.class);
		given(product.getPrice()).willReturn(expectedProductPrice);
		Order order = new Order(Collections.singletonList(product));

		// when
		BigDecimal actualProductPrice = order.getPrice();

		// then
		assertBigDecimalCompareValue(expectedProductPrice, actualProductPrice);
	}

	private Order getOrderWithCertainNumberOfProductsAndPrice(int numberOfProducts, double productPriceValue) {
		BigDecimal productPrice = BigDecimal.valueOf(productPriceValue);
		List<Product> products = new ArrayList<>();
		IntStream.range(0, numberOfProducts)
				.forEach(i -> {
					Product product = mock(Product.class);
					given(product.getPrice()).willReturn(productPrice);
					given(product.getDiscountedPrice()).willReturn(productPrice);
					products.add(product);
				});

		return new Order(products);
	}

	@Test
	public void testPriceWithNoProductsInOrder() {
		//given, when
		Order order = new Order(Collections.emptyList()); // 0 PLN

		//then
		assertBigDecimalCompareValue(BigDecimal.valueOf(0), order.getPrice()); // 0 PLN
	}

	@Test
	public void testPriceWithTaxesWithoutRoundUp() {
		// given

		// when
		Order order = getOrderWithCertainNumberOfProductsAndPrice(1,2); // 2 PLN

		// then
		assertBigDecimalCompareValue(order.getPriceWithTaxes(), BigDecimal.valueOf(2.46)); // 2.46 PLN
	}

	@Test
	public void testPriceWithTaxesWithRoundDown() {
		// given

		// when
		Order order = getOrderWithCertainNumberOfProductsAndPrice(2,0.01); // 0.02 PLN

		// then
		assertBigDecimalCompareValue(order.getPriceWithTaxes(), BigDecimal.valueOf(0.02)); // 0.02 PLN
																							
	}

	@Test
	public void testPriceWithTaxesWithRoundUp() {
		// given

		// when
		Order order = getOrderWithCertainNumberOfProductsAndPrice(4, 0.03); // 0.12 PLN

		// then
		assertBigDecimalCompareValue(order.getPriceWithTaxes(), BigDecimal.valueOf(0.15)); // 0.15 PLN
																							
	}

	@Test
	public void testProductDiscountedPrices() {
		//given
		Product product1 = mock(Product.class);
		given(product1.getDiscountedPrice()).willReturn(BigDecimal.valueOf(2.5));  // 2.5 PLN
		Product product2 = mock(Product.class);
		given(product2.getDiscountedPrice()).willReturn(BigDecimal.valueOf(5)); // 5 PLN

		//when
		Order order = new Order(Arrays.asList(product1, product2));

		//then
		assertBigDecimalCompareValue(BigDecimal.valueOf(7.5), order.getPriceWithProductsDiscount()); // 7.5 PLN
	}

	@Test
	public void testOrderDiscountWithRoundUp() {
		//given
		Product product1 = mock(Product.class);
		given(product1.getDiscountedPrice()).willReturn(BigDecimal.valueOf(5));  // 5 PLN
		Product product2 = mock(Product.class);
		given(product2.getDiscountedPrice()).willReturn(BigDecimal.valueOf(0.7)); // 0.7 PLN

		//when
		Order order = new Order(Arrays.asList(product1, product2), new Discount(5)); // 5.7 PLN * 0.95 = 5.415 = 5.42 PLN

		//then
		assertBigDecimalCompareValue(BigDecimal.valueOf(5.42), order.getPriceWithOrderDiscount());
	}

	@Test
	public void testOrderDiscountWithoutRounding() {
		//given
		Product product1 = mock(Product.class);
		given(product1.getDiscountedPrice()).willReturn(BigDecimal.valueOf(5));  // 5 PLN
		Product product2 = mock(Product.class);
		given(product2.getDiscountedPrice()).willReturn(BigDecimal.valueOf(1)); // 1 PLN

		//when
		Order order = new Order(Arrays.asList(product1, product2), new Discount(8)); // 6 PLN * 0.92 = 5.52 PLN

		//then
		assertBigDecimalCompareValue(BigDecimal.valueOf(5.52), order.getPriceWithOrderDiscount());
	}

	@Test
	public void testSetShipmentMethod() {
		// given
		Order order = getOrderWithMockedProduct();
		ShipmentMethod surface = mock(SurfaceMailBus.class);

		// when
		order.setShipmentMethod(surface);

		// then
		assertSame(surface, order.getShipmentMethod());
	}

	@Test
	public void testSending() {
		// given
		Order order = getOrderWithMockedProduct();
		SurfaceMailBus surface = mock(SurfaceMailBus.class);
		Shipment shipment = mock(Shipment.class);
		given(shipment.isShipped()).willReturn(true);

		// when
		order.setShipmentMethod(surface);
		order.setShipment(shipment);
		order.send();

		// then
		assertTrue(order.isSent());
	}

	@Test
	public void testIsSentWithoutSending() {
		// given
		Order order = getOrderWithMockedProduct();
		Shipment shipment = mock(Shipment.class);
		given(shipment.isShipped()).willReturn(true);

		// when

		// then
		assertFalse(order.isSent());
	}

	@Test
	public void testWhetherIdExists() throws Exception {
		// given
		Order order = getOrderWithMockedProduct();

		// when

		// then
		assertNotNull(order.getId());
	}

	@Test
	public void testSetPaymentMethod() throws Exception {
		// given
		Order order = getOrderWithMockedProduct();
		PaymentMethod paymentMethod = mock(MoneyTransferPaymentTransaction.class);

		// when
		order.setPaymentMethod(paymentMethod);

		// then
		assertSame(paymentMethod, order.getPaymentMethod());
	}

	@Test
	public void testPaying() throws Exception {
		// given
		Order order = getOrderWithMockedProduct();
		PaymentMethod paymentMethod = mock(MoneyTransferPaymentTransaction.class);
		given(paymentMethod.commit(any(MoneyTransfer.class))).willReturn(true);
		MoneyTransfer moneyTransfer = mock(MoneyTransfer.class);
		given(moneyTransfer.isCommitted()).willReturn(true);

		// when
		order.setPaymentMethod(paymentMethod);
		order.pay(moneyTransfer);

		// then
		assertTrue(order.isPaid());
	}

	@Test
	public void testIsPaidWithoutPaying() throws Exception {
		// given
		Order order = getOrderWithMockedProduct();

		// when

		// then
		assertFalse(order.isPaid());
	}
}
