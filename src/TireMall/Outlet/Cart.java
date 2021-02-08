package TireMall.Outlet;

import TireMall.Commands.Command;
import TireMall.Commands.State;
import TireMall.Commands.UseCommands;

import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.Stream;

public class Cart {

    final ArrayList<CartItem> items = new ArrayList<>();
    final Stack<Command> undoStack = new Stack<>();


    public void addItem (CartItem item){
        UseCommands.addHistoryState(new State(() -> {
            System.out.println("Removs the :" + item.tire().name());
            items.remove(item);
        }, () -> {
            System.out.println("Add again : " + item.tire().name());
            items.add(item);
        }));
        items.add(item);
    }
    public Stream<CartItem> stream(){return items.stream();}
}

