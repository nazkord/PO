package pl.edu.agh.internetshop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {
	
	public static final int PRICE_PRECISION = 2;
	public static final RoundingMode ROUND_STRATEGY = RoundingMode.HALF_UP;
	
    private final String name;
    private final BigDecimal price;
    private final Discount discount;
    private final BigDecimal discountedPrice;

    public Product(String name, BigDecimal price, Discount discount) {
        this.name = name;
        this.discount = discount;
        this.price = price.setScale(PRICE_PRECISION, ROUND_STRATEGY);
        this.discountedPrice = applyDiscountTo(price);
    }

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
        this.discount = new Discount(0);
        this.discountedPrice = price;
    }

    private BigDecimal applyDiscountTo(BigDecimal price) {
        return discount.applyTo(price);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getDiscountedPrice() {
        return discountedPrice;
    }
}
