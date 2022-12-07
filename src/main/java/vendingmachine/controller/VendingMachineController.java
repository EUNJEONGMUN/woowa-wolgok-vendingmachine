package vendingmachine.controller;

import vendingmachine.domain.Money;
import vendingmachine.domain.ProductName;
import vendingmachine.domain.dto.StockDto;
import vendingmachine.service.CoinService;
import vendingmachine.service.ProductService;
import vendingmachine.service.VendingMachineService;
import vendingmachine.util.ProductInfoParser;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class VendingMachineController {
    private final VendingMachineService vendingMachineService = new VendingMachineService();
    private final CoinService coinService = new CoinService();
    private final ProductService productService = new ProductService();

    public void init() {
        machineCoinSetting();
        machineStockSetting();
        userMoneySetting();
        start();
    }

    private void machineCoinSetting() {
        Money money = read(Money::from, InputView::readVendingMachineMoney);
        coinService.setVendingMachineMoney(money);
        OutputView.printVendingMachineCoin(coinService.getMachineCoin());
    }

    private void machineStockSetting() {
        List<StockDto> productInfos = read(ProductInfoParser::makeStockList, InputView::readProductInfo);
        productService.setVendingMachineStock(productInfos);
    }

    private void userMoneySetting() {
        Money userMoney = read(Money::from, InputView::readMoney);
        vendingMachineService.insertMoney(userMoney);
    }

    private void start() {
        while (vendingMachineService.isAvailable()) {
            OutputView.printRemainMoney(vendingMachineService.getUserMoney());
            try {
                vendingMachineService.sellProduct(read(ProductName::from, InputView::readProductName));
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
        endMachine();
    }

    private void endMachine() {
        OutputView.printRemainMoney(vendingMachineService.getUserMoney());
        OutputView.printChanges(vendingMachineService.returnChange());
    }

    private <T, R> R read(Function<T, R> object, Supplier<T> input) {
        while (true) {
            try {
                return object.apply(input.get());
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}