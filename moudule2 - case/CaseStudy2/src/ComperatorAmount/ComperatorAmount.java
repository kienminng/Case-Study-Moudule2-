package ComperatorAmount;

import Cart.Cart;

import java.util.Comparator;

public class ComperatorAmount implements Comparator<Cart> {
    @Override
    public int compare(Cart o1, Cart o2) {
        if (o1.getAmount() > o2.getAmount()) {
            return -1;

        } else if (o1.getAmount()==o2.getAmount()) {
            return 0;
        } else {
            return 1;
        }
    }
}
