package vendingmachine.view;

import vendingmachine.domain.dto.CoinStatusDto;

import java.util.Comparator;
import java.util.Map;

public class OutputView {
    private static final String PRINT_COIN_FORMAT = "%d원 - %d개";
    private static final String PRINT_MONEY_FORMAT = "\n투입 금액: %d원";

    public static void printVendingMachineCoin(CoinStatusDto status) {
        System.out.println("자판기가 보유한 동전");
        Map<Integer, Integer> coinStatus = status.getCoinStatus();
        coinStatus.keySet().stream().sorted(Comparator.reverseOrder())
                .forEach(coin -> {
                    System.out.printf(PRINT_COIN_FORMAT, coin, coinStatus.get(coin));
                    System.out.println();
                });
    }

    public static void printChanges(CoinStatusDto status) {
        System.out.println("잔돈");
        Map<Integer, Integer> coinStatus = status.getCoinStatus();
        coinStatus.keySet().stream().sorted(Comparator.reverseOrder())
                .filter(coin -> coinStatus.get(coin) != 0)
                .forEach(coin -> {
                    System.out.printf(PRINT_COIN_FORMAT, coin, coinStatus.get(coin));
                    System.out.println();
                });
    }

    public static void printRemainMoney(int money) {
        System.out.printf(PRINT_MONEY_FORMAT, money);
        System.out.println();
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}