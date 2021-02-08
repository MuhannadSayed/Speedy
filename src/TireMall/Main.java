package TireMall;

import TireMall.Commands.UseCommands;
import TireMall.Outlet.Cart;
import TireMall.Outlet.CartItem;
import TireMall.Outlet.Cash;
import TireMall.Outlet.Tire;

public class Main {

    public static void main (String[] args){

        Cart cart = new Cart();
        Cash cash = new Cash();

        Tire t1 = new Tire("Bridgestone");
        Tire t2 = new Tire("Continental");
        Tire t3 = new Tire("Firestone");
        Tire t4 = new Tire("General");

        CartItem cartItem = new CartItem(t1 , 1000 , 4);
        CartItem cartItem2 = new CartItem(t2 , 200 , 2);
        CartItem cartItem3 = new CartItem(t3 , 500 , 1);
        CartItem cartItem4 = new CartItem(t4 , 250 , 3);

        cart.addItem(cartItem);
        cart.addItem(cartItem2);
        cart.addItem(cartItem3);
        cart.addItem(cartItem4);

        UseCommands.undo();

        System.out.println(cash.invoice(cart));
        UseCommands.redo();
        System.out.println(cash.invoice(cart));

        UseCommands.undo();

        System.out.println(cash.invoice(cart));

    }
}
