package TireMall.strategy;

import TireMall.Outlet.CartItem;

import java.math.BigDecimal;
import java.util.ArrayList;

public class SaleWithAll  implements Sale{

    @Override
    public BigDecimal apply(ArrayList<CartItem> items) {
        var sum = BigDecimal.ZERO;
        var finalAmount = BigDecimal.ZERO;

        for (var item: items) {
            sum = item.itemPrice().multiply(BigDecimal.valueOf(item.quantity())).add(sum);
        }

        if(sum.doubleValue() >= 3000){
            System.out.println("WoW you have sale on all tires !!!!");
            finalAmount = sum.multiply(BigDecimal.valueOf(0.2));
        }
        return finalAmount;
    }
}
