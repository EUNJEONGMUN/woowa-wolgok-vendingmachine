package vendingmachine.service;

import vendingmachine.domain.*;
import vendingmachine.domain.dto.CoinStatusDto;

public class VendingMachineService {
    private Stock stock = Stock.getInstance();
    private MachineCoin machineCoin = MachineCoin.getInstance();
    private Money userMoney;

    public void insertMoney(Money money) {
        this.userMoney = money;
    }

    public void sellProduct(ProductName productName) {
        Product product = stock
                .findByName(productName)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 상품이 존재하지 않습니다."));

        if (!product.isCanBuy(userMoney.getMoney())) {
            throw new IllegalArgumentException("[ERROR] 금액이 모자라 살 수 없습니다.");
        }
        stock.minusStock(product);
        userMoney.buyProduct(product.getPrice());
    }

    public CoinStatusDto returnChange() {
        return machineCoin.getChange(userMoney.returnChange());
    }

    public int getUserMoney() {
        return userMoney.getMoney();
    }

    public boolean isAvailable() {
        if (stock.isAllProductSoldOut()
                || !stock.isExistsCanBuy(userMoney.getMoney())) {
            return false;
        }
        return true;
    }
}