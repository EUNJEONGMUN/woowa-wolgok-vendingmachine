package vendingmachine.util;

import vendingmachine.domain.Product;
import vendingmachine.domain.dto.StockDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductInfoParser {
    public static final String PRODUCT_DELIMITER = ";";
    public static final String PRODUCT_INFO_DELIMITER = ",";
    public static final String PRODUCT_INFO_PREFIX = "[";
    public static final String PRODUCT_INFO_SUFFIX = "]";
    public static final int PRODUCT_NAME_INDEX = 0;
    public static final int PRODUCT_PRICE_INDEX = 1;
    public static final int PRODUCT_AMOUNT_INDEX = 2;

    public static List<StockDto> makeStockList(String productInfos) {
        return removeDelimiter(productInfos).stream().map(info -> makeProductInfoDto(info))
                .collect(Collectors.toList());
    }

    private static StockDto makeProductInfoDto(String info) {
        String[] splitInfo = info.split(PRODUCT_INFO_DELIMITER);
        return StockDto.of(Product.of(splitInfo[PRODUCT_NAME_INDEX],
                        Integer.parseInt(splitInfo[PRODUCT_PRICE_INDEX])),
                Integer.parseInt(splitInfo[PRODUCT_AMOUNT_INDEX]));
    }

    private static List<String> removeDelimiter(String productInfos) {
        return Arrays.stream(productInfos.split(PRODUCT_DELIMITER))
                .map(s -> s.replace(PRODUCT_INFO_PREFIX, "")
                        .replace(PRODUCT_INFO_SUFFIX, "")
                        .replace(" ", ""))
                .collect(Collectors.toList());
    }
}