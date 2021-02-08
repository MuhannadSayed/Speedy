package TireMall.Outlet;

import TireMall.strategy.SaleCheapest;
import TireMall.strategy.SaleThreeForFour;
import TireMall.strategy.SaleWithAll;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Cash {
    SaleWithAll saleWithAll = new SaleWithAll();
    SaleCheapest saleCheapest = new SaleCheapest();
    SaleThreeForFour saleThreeForFour = new SaleThreeForFour();

    public BigDecimal calculatePrice (Cart cart){
        var sum  = BigDecimal.ZERO;
        for (var item: cart.items){
            sum = item.itemPrice().multiply(BigDecimal.valueOf(item.quantity())).add(sum);
        }
        sum.subtract(calculateSale(cart));
        return sum;

    }

    public BigDecimal calculateSale(Cart cart) {
        var threeForFour = saleThreeForFour.apply(cart.items);
        var withAll = saleWithAll.apply(cart.items);
        var cheapest = saleCheapest.apply(cart.items);

        int[] newNum = {threeForFour.intValue(),withAll.intValue(),cheapest.intValue()};
        Arrays.sort(newNum);

        var total = newNum[newNum.length-1];
        return BigDecimal.valueOf(total);
    }

    public String invoice(Cart cart){
        String startLine = "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n";
        String endLine = ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n";
        StringBuilder sb = new StringBuilder();
        sb.append(startLine);

        var order = cart.items.stream()
                .sorted(Comparator.comparing(item -> item.tire().name()))
                .collect(Collectors.toList());
        for (var each : order){
            sb.append(String.format("%-24s % 7.2f\n" , each.tire().name(),each.itemPrice()));
        }
        sb.append(endLine);
        sb.append(String.format("%24s% 8.2f" , "TOTAL:" , calculatePrice(cart)));
        return sb.toString();

    }
}
