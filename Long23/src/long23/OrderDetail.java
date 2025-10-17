package long23;

public class OrderDetail {
    private Fruit fruit;
    private int quantity;

    public OrderDetail(Fruit fruit, int quantity) {
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /** Luôn tính theo giá hiện tại của Fruit */
    public double getAmount() {
        return quantity * fruit.getPrice();
    }

    @Override
    public String toString() {
        return String.format("%-10s | %5d | %6.2f$ | %6.2f$",
                fruit.getName(), quantity, fruit.getPrice(), getAmount());
    }
}
