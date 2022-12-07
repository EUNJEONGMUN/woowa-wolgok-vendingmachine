package vendingmachine.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumber {
    public static Integer generateRandomCoin(List<Integer> coins) {
        return Randoms.pickNumberInList(coins);
    }
}