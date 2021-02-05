package TireMall.Showroom;

import java.math.BigDecimal;
import org.jetbrains.annotations.NotNull;

public class CartItem {

    private final BigDecimal itemCost;
    private final Tire tire;
    private final int quantity;

    public BigDecimal itemCost() {
        return itemCost;
    }

    public Tire tire() {
        return tire;
    }

    public int quantity() {
        return quantity;
    }

    public CartItem(@NotNull Tire tire , double itemCost , int quantity) {

        this.itemCost = BigDecimal.valueOf(itemCost);
        this.tire = tire;
        this.quantity = quantity;


    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartItem defItem = (CartItem) o;

        if (quantity != defItem.quantity) return false;
        if (!itemCost.equals(defItem.itemCost)) return false;
        return tire.equals(defItem.tire);
    }


    @Override
    public int hashCode() {
        int result = itemCost.hashCode();
        result = 31 * result + tire.hashCode();
        result = 31 * result + quantity;
        return result;
    }

}
