package vendingmachine.domain;

public class Money {
    private static final int MONEY_UNIT = 10;
    private int money;

    private Money(int money) {
        validateRange(money);
        validateUnit(money);
        this.money = money;
    }

    public static Money from(int money) {
        return new Money(money);
    }

    private void validateRange(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 양수로 입력해야 합니다.");
        }
    }

    private void validateUnit(int money) {
        if (money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 10원 단위로 입력해야 합니다.");
        }
    }

    public void buyProduct(int price) {
        this.money -= price;
    }

    public int getMoney() {
        return money;
    }

    public int returnChange() {
        int change = money;
        money = 0;
        return change;
    }
}