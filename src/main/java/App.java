import com.thoughtworks.iamcoach.pos.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    ItemServer itemServer = new ItemServer();
    Cart cart = new Cart();
    Pos pos = new Pos();
    List<String> cartBarcodes = cart.getBarcodes();
    List<Item> boughtItems = new ArrayList<Item>();
    try {
      List<BoughtItem> cartItems = pos.handleBarcodes(cartBarcodes);
      for (BoughtItem cartItem : cartItems) {
        Item item = itemServer.findItem(cartItem.getBarcode());
        boughtItems.add(item);
      }
      
    } catch (IOException e) {
      e.printStackTrace();
    }

    calculatePromotion(boughtItems);
  }

  private static void calculatePromotion(List<Item> boughtItems) {

  }
}
