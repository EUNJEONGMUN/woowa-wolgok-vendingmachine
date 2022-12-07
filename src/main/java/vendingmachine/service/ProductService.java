package vendingmachine.service;

import vendingmachine.domain.dto.StockDto;
import vendingmachine.domain.Stock;

import java.util.List;

public class ProductService {
    private Stock stock = Stock.getInstance();

    public void setVendingMachineStock(List<StockDto> stock) {
        stock.stream().forEach(this::addStock);
    }

    public void addStock(StockDto stockDto) {
        stock.addStock(stockDto.getProduct(), stockDto.getQuantity());
    }
}