package vendingmachine.util;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Validator {
    private static final String PRODUCT_INFO_REGEX = "\\[[a-zA-Z가-힣ㄱ-ㅎㅏ-ㅣ0-9]+,[0-9]+,[0-9]+]";

    private static final Pattern productInfoPattern = Pattern.compile(PRODUCT_INFO_REGEX);
    private static final String PRODUCT_DELIMITER = ";";

    public static void validIsNumber(String value) {
        try {
            Integer.parseInt(value);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }

    public static void validProductInfoShape(String infos) {
        boolean result = Arrays.stream(infos.split(PRODUCT_DELIMITER))
                .allMatch(info -> productInfoPattern.matcher(info).matches());
        if (!result) {
            throw new IllegalArgumentException("[ERROR] 상품 입력 형식이 올바르지 않습니다.");
        }
    }
}