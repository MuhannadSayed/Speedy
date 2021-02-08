package TireMall.Outlet;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public class CartItem {

    private final BigDecimal itemPrice;
    private final Tire tire;
    private final int quantity;

    public BigDecimal itemPrice() {
        return itemPrice;
    }

    public Tire tire() {
        return tire;
    }

    public int quantity() {
        return quantity;
    }

    public CartItem(@NotNull Tire tire , double itemPrice, int quantity) {

        this.itemPrice = BigDecimal.valueOf(itemPrice);
        this.tire = tire;
        this.quantity = quantity;


    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartItem DefItem = (CartItem) o;

        if (quantity != DefItem.quantity) return false;
        if (!itemPrice.equals(DefItem.itemPrice)) return false;
        return tire.equals(DefItem.tire);
    }


    @Override
    public int hashCode() {
        int result = itemPrice.hashCode();
        result = 31 * result + tire.hashCode();
        result = 31 * result + quantity;
        return result;
    }

}
