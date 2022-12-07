package vendingmachine.service;

import vendingmachine.domain.Money;
import vendingmachine.domain.dto.CoinStatusDto;
import vendingmachine.domain.MachineCoin;

public class CoinService {
    private MachineCoin machineCoin = MachineCoin.getInstance();

    public void setVendingMachineMoney(Money money) {
        machineCoin.setMachineCoin(money);
    }

    public CoinStatusDto getMachineCoin() {
        return machineCoin.getMachineCoin();
    }
}