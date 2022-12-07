package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static Coin from(int amount) {
        return Arrays.stream(Coin.values())
                .filter(coin -> coin.amount == amount)
                .findAny()
                .get();
    }

    public static List<Integer> getAvailableCoins(int money) {
        return Arrays.stream(Coin.values())
                .map(coin -> coin.getAmount())
                .filter(coin -> coin <= money)
                .collect(Collectors.toList());
    }

    public static List<Coin> getAllCoins() {
        return Arrays.stream(Coin.values()).collect(Collectors.toUnmodifiableList());
    }

    public int getAmount() {
        return amount;
    }
}