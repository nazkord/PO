package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static pl.edu.agh.internetshop.util.CustomAssertions.assertBigDecimalCompareValue;

import java.math.BigDecimal;


public class ProductTest {

    private static final String NAME = "Mr. Sparkle";
    private static final BigDecimal PRICE = BigDecimal.valueOf(1);

	@Test
    public void testProductName() throws Exception{
        //given
    	
        // when
        Product product = new Product(NAME, PRICE);
        
        // then
        assertEquals(NAME, product.getName());
    }
    
    @Test
    public void testProductPriceWithoutDiscount() throws Exception{
        //given
    	
        // when
        Product product = new Product(NAME, PRICE);
        
        // then
        assertBigDecimalCompareValue(product.getPrice(), PRICE);
    }

    @Test
    public void testPriceWithFullDiscount() {
	    //given

        //when
        Product product = new Product(NAME, PRICE, new Discount(100));

        //then
        assertBigDecimalCompareValue(BigDecimal.valueOf(0), product.getDiscountedPrice());
    }

    @Test
    public void testPriceWithTooBigDiscount() {
	    assertThrows(IllegalArgumentException.class, () -> new Product(NAME, PRICE, new Discount(101)));
    }

    @Test
    public void testPriceWithTooSmallDiscount() {
        assertThrows(IllegalArgumentException.class, () -> new Product(NAME, PRICE, new Discount(-1)));
    }

    @Test
    public void testPriceWithDiscount() {
	    //given

        //when
        Product product = new Product(NAME, PRICE, new Discount(50)); // price -> 1 PLN, with discount -> 0.50 PLN

        //then
        assertBigDecimalCompareValue(BigDecimal.valueOf(0.5), product.getDiscountedPrice());
    }
}