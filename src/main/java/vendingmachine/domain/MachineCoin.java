package vendingmachine.domain;

import vendingmachine.domain.dto.CoinStatusDto;
import vendingmachine.util.RandomNumber;

import java.util.EnumMap;

public class MachineCoin {
    private static MachineCoin instance;
    private EnumMap<Coin, Integer> machineCoin = new EnumMap<>(Coin.class) {
    };

    private MachineCoin() {
    }

    public static MachineCoin getInstance() {
        if (instance == null) {
            instance = new MachineCoin();
        }
        return instance;
    }

    public void setMachineCoin(Money money) {
        Coin.getAllCoins().stream()
                .forEach(coin -> machineCoin.put(coin, 0));
        createRandomCoin(money.getMoney());
    }

    private void createRandomCoin(int money) {
        while (money > 0) {
            Integer randomCoin = RandomNumber.generateRandomCoin(Coin.getAvailableCoins(money));
            money -= randomCoin;
            machineCoin.put(Coin.from(randomCoin), machineCoin.get(Coin.from(randomCoin)) + 1);
        }
    }

    public CoinStatusDto getMachineCoin() {
        return new CoinStatusDto(machineCoin);
    }

    public CoinStatusDto getChange(int money) {
        EnumMap<Coin, Integer> result = new EnumMap<>(Coin.class);
        for (Coin coin : machineCoin.keySet()) {
            if (money <= 0) {
                break;
            }
            int numOfCoin = numberOfMaximumCoin(money, coin);
            result.put(coin, numOfCoin);
            money -= coin.getAmount() * numOfCoin;
        }
        return new CoinStatusDto(result);
    }

    private int numberOfMaximumCoin(int money, Coin coin) {
        if (money <= coin.getAmount() * machineCoin.get(coin)) {
            return money / coin.getAmount();
        }
        return machineCoin.get(coin);
    }
}