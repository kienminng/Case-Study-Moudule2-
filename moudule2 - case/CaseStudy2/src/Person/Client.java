package Person;

import Cart.Cart;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Client extends Person implements Serializable {
    private List<Cart> cart;

    public Client() {
    }

    public Client(String name, String account, String pass, LocalDate date, String gender) {
        super(name, account, pass, date, gender);
    }

    public Client(String name, String account, String pass, LocalDate date, String gender, List<Cart> cart) {
        super(name, account, pass, date, gender);
        this.cart =cart;
    }

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "Client{" +
                "cart=" + cart +
                "} " + super.toString();
    }
}
