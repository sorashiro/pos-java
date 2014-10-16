import com.thoughtworks.iamcoach.pos.PrintItem;

import java.util.Date;
import java.util.List;

public class Output {
    public static void printShoppingList(List<PrintItem> printItemList) {
        Date date = new Date();
        String shoppingList = "**********沃尔玛超市**********\n";
        //TODO need to replace with guava;
        shoppingList += date + "\n\n";
        Double total = 0.00;
        Double sum = 0.00;
        for (PrintItem printItem : printItemList) {
            shoppingList += printItem.getName() + " ";
            shoppingList += printItem.getNumber();
            shoppingList += printItem.getUnit() + " ";
            shoppingList += printItem.getPrice() + "元 ";
            shoppingList += printItem.getSubtotal() + "元\n";
            total += printItem.getSubtotal();
            sum += printItem.getNumber() * printItem.getPrice();
        }
        shoppingList += "优惠前金额:" + sum + "元 \n";
        shoppingList += "优惠后金额:" + total + "元 \n";
        shoppingList += "优惠差价:" + (sum - total) + "元";

        System.out.println(shoppingList);
    }
}
