import com.thoughtworks.iamcoach.pos.BoughtItem;
import com.thoughtworks.iamcoach.pos.Cart;
import com.thoughtworks.iamcoach.pos.Pos;

import java.io.IOException;
import java.util.List;

public class App {
  public static void main(String[] args) {
    Cart cart = new Cart();
    Pos pos = new Pos();
    List<String> cartBarcodes = cart.getBarcodes();
    try {
      List<BoughtItem> boughtItems = pos.handleBarcodes(cartBarcodes);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
