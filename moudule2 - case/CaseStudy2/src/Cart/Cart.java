package Cart;

import java.io.Serializable;

public class Cart implements Serializable {
    private String nameSP;
    private int amount=1;
    private double price;

    public Cart() {
    }

    public Cart(String nameSP, int amount, double price) {
        this.nameSP = nameSP;
        this.amount = amount;
        this.price = price;
    }

    public String getNameSP() {
        return nameSP;
    }

    public void setNameSP(String nameSP) {
        this.nameSP = nameSP;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Cart{" +
                "nameSP='" + nameSP + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
