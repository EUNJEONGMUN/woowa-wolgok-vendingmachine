package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.util.Validator;

public class InputView {

    public static int readVendingMachineMoney() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        String input = Console.readLine();
        Validator.validIsNumber(input);
        return Integer.parseInt(input);
    }

    public static String readProductInfo() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        String input = Console.readLine();
        Validator.validProductInfoShape(input);
        return input;
    }

    public static int readMoney() {
        System.out.println("투입 금액을 입력해 주세요.");
        String input = Console.readLine();
        Validator.validIsNumber(input);
        return Integer.parseInt(input);
    }

    public static String readProductName() {
        System.out.println("구매할 상품명을 입력해 주세요.");
        return Console.readLine();
    }
}