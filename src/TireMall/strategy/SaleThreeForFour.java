package TireMall.strategy;

import TireMall.Outlet.CartItem;

import java.math.BigDecimal;
import java.util.ArrayList;

public class SaleThreeForFour implements Sale {

    @Override
    public BigDecimal apply(ArrayList<CartItem> items) {

        var GetItemCost = BigDecimal.ZERO;

        for (var item : items) {
            for (var i = 3; i < item.quantity(); i+=4 ) {
                GetItemCost = item.itemPrice().add(GetItemCost);
            }
        }
        return GetItemCost;
    }
}
