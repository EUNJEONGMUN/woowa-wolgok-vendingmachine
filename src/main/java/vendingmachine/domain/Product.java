package vendingmachine.domain;

import java.util.Objects;

public class Product {
    private static final int PRICE_MINIMUM = 100;
    private static final int PRICE_UNIT = 10;

    private final ProductName name;
    private final int price;

    private Product(ProductName name, int price) {
        validPrice(price);
        this.name = name;
        this.price = price;
    }

    public static Product of(String name, int price) {
        return new Product(ProductName.from(name), price);
    }

    private void validPrice(int price) {
        validOverMinimumPrice(price);
        validPriceUnit(price);
    }

    private void validOverMinimumPrice(int price) {
        if (price < PRICE_MINIMUM) {
            throw new IllegalArgumentException("[ERROR] 상품가격은 100원부터 시작합니다.");
        }
    }

    private void validPriceUnit(int price) {
        if (price % PRICE_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 상품가격은 10원으로 나누어떨어져야 합니다.");
        }
    }

    public int getPrice() {
        return price;
    }

    public boolean isCanBuy(int money) {
        return price <= money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if ((obj instanceof Product)) {
            if (((Product) obj).name.equals(this.name)) {
                return true;
            }
            return false;
        }
        if (obj.equals(this.name)) {
            return true;
        }
        return false;
    }
}