import com.thoughtworks.iamcoach.pos.*;

import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    Cart cart = new Cart();
    Pos pos = new Pos();
    Discount discount = new Discount();
    List<String> cartBarcodes = cart.getBarcodes();
    List<BoughtItem> boughtItems = new ArrayList<BoughtItem>();


      boughtItems = pos.handleBarcodes(cartBarcodes);



    List<Promotion> promotions = discount.getPromotions();
      pos.calculatePromotion(boughtItems);

  }

}
