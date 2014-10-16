import com.thoughtworks.iamcoach.pos.PrintItem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Output {
    public static void printShoppingList(List<PrintItem> printItemList) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 - HH:mm");
        String date = formatter.format(LocalDateTime.now());
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
