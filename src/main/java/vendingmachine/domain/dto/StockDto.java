package vendingmachine.domain.dto;

import vendingmachine.domain.Product;

public class StockDto {
    private final Product product;
    private final int quantity;

    private StockDto(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public static StockDto of(Product product, int quantity) {
        return new StockDto(product, quantity);
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}