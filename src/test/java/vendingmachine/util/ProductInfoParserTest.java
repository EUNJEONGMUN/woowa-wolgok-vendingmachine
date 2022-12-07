package vendingmachine.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.domain.Product;
import vendingmachine.domain.dto.StockDto;

import java.util.List;

import static org.assertj.core.api.Assertions.tuple;

class ProductInfoParserTest {
    ProductInfoParser parser = new ProductInfoParser();

    @DisplayName("상품 정보의 매핑 확인")
    @Test
    void makeStockList() {
        List<StockDto> stockDtos = parser.makeStockList("[콜라,1000,10]");
        Product product = Product.of("콜라", 1000);

        Assertions.assertThat(stockDtos.get(0))
                .extracting("product", "quantity")
                .containsExactly(product, 10);
    }
}