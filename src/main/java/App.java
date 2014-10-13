import com.thoughtworks.iamcoach.pos.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    Cart cart = new Cart();
    Pos pos = new Pos();
    List<String> cartBarcodes = cart.getBarcodes();
    List<BoughtItem> boughtItems = new ArrayList<BoughtItem>();
    try {
      boughtItems = pos.handleBarcodes(cartBarcodes);

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
