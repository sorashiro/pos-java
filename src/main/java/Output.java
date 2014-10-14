import com.thoughtworks.iamcoach.pos.PrintItem;

import java.util.List;

public class Output {
    public static void printShoppingList(List<PrintItem> printItemList) {
        String shoppingList = "";
        for (PrintItem printItem : printItemList) {
            shoppingList += printItem.getBoughtItem().getItem().getName() + " ";
            shoppingList += printItem.getBoughtItem().getNumber();
            shoppingList += printItem.getBoughtItem().getItem().getUnit() + " ";
            shoppingList += printItem.getBoughtItem().getPrice() + "元 ";
            shoppingList += printItem.getSubtotal() + "元\n";
        }

        System.out.println(shoppingList);
    }
}
