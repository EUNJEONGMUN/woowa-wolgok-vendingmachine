package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Stock {
    private static Stock instance;
    private final Map<Product, Integer> stock = new HashMap<>();

    private Stock() {
    }

    public static Stock getInstance() {
        if (instance == null) {
            instance = new Stock();
        }
        return instance;
    }

    public void addStock(Product product, int amount) {
        stock.put(product, amount);
    }

    public void minusStock(Product product) {
        stock.put(product, stock.get(product) - 1);
    }

    public Optional<Product> findByName(ProductName productName) {
        return stock.keySet().stream()
                .filter(product -> product.equals(productName) && !isSoldOut(product))
                .findAny();
    }

    public boolean isAllProductSoldOut() {
        return stock.keySet().stream()
                .allMatch(product -> isSoldOut(product));
    }

    public boolean isExistsCanBuy(int money) {
        return stock.keySet().stream()
                .anyMatch(product -> product.getPrice() <= money);
    }

    private boolean isSoldOut(Product product) {
        return stock.get(product) == 0;
    }
}