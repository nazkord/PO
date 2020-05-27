package pl.edu.agh.internetshop;

import java.math.BigDecimal;

import static pl.edu.agh.internetshop.Product.PRICE_PRECISION;
import static pl.edu.agh.internetshop.Product.ROUND_STRATEGY;

public class Discount {

    public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);
    private final BigDecimal discountPercentage;

    public Discount(int discountPercentage) {
        if(discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("DiscountPercentage has to be in range from 0 to 100, but was: " + discountPercentage);
        }
        this.discountPercentage = BigDecimal.valueOf(discountPercentage);
    }

    public BigDecimal applyTo(BigDecimal price) {
        return price.multiply(BigDecimal.ONE.subtract(discountPercentage.divide(ONE_HUNDRED, PRICE_PRECISION, ROUND_STRATEGY))).setScale(PRICE_PRECISION, ROUND_STRATEGY);
    }
}