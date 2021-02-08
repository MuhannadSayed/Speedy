package TireMall.strategy;

import java.math.BigDecimal;
import java.util.ArrayList;
import TireMall.Outlet.CartItem;

public interface Sale {

    BigDecimal apply (ArrayList<CartItem> items);


}
