package vendingmachine.domain;

import java.util.Objects;

public class ProductName {
    private String name;

    private ProductName(String name) {
        this.name = name;
    }

    public static ProductName from(String name) {
        return new ProductName(name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.equals(name)) {
            return true;
        }
        return false;
    }
}
