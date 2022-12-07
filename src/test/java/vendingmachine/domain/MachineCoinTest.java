package vendingmachine.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.domain.dto.CoinStatusDto;

import java.util.HashMap;
import java.util.Map;

class MachineCoinTest {

//    @DisplayName("금액에 해당하는 랜덤 동전을 생성한다.")
//    @Test
//    void createRandomCoin() {
//        int money = 3000;
//        MachineCoin machineCoin = new MachineCoin(3000);
//        Map<Integer, Integer> coinStatus = machineCoin.getMachineCoin().getCoinStatus();
//        int result = 0;
//        for (Integer coin : coinStatus.keySet()) {
//            System.out.println(coin + " " + coinStatus.get(coin));
//            result += (coin * coinStatus.get(coin));
//        }
//        Assertions.assertThat(result).isEqualTo(money);
//    }
//
//    @DisplayName("가장 큰 금액으로 잔돈을 반환한다.")
//    @Test
//    void returnCoin() {
//        MachineCoin machineCoin = new MachineCoin(1600);
//        CoinStatusDto coinStatusDto = machineCoin.getRemainCoin(1600);
//        Map<Integer, Integer> result = coinStatusDto.getCoinStatus();
//
//        Map<Integer, Integer> expected = new HashMap<>();
//        expected.put(500, 3);
//        expected.put(100, 1);
//        Assertions.assertThat(result).isEqualTo(expected);
//    }
//
//    @DisplayName("반환할 수 있을만큼 반환한다.")
//    @Test
//    void returnCoin2() {
//        MachineCoin machineCoin = new MachineCoin(1500);
//        CoinStatusDto coinStatusDto = machineCoin.getRemainCoin(1600);
//        Map<Integer, Integer> result = coinStatusDto.getCoinStatus();
//
//        Map<Integer, Integer> expected = new HashMap<>();
//        expected.put(500, 3);
//        Assertions.assertThat(result).isEqualTo(expected);
//    }
}