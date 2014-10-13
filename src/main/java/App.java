import com.thoughtworks.iamcoach.pos.*;

import java.util.List;

public class App {
  public static void main(String[] args) {
    
    Cart cart = new Cart();
    List<String> cartBarcodes = cart.getBarcodes();

    Pos pos = new Pos();
    List<BoughtItem> boughtItems = pos.handleBarcodes(cartBarcodes);

    Discount discount = new Discount();
    List<Promotion> promotions = discount.getPromotions();
      pos.calculatePromotion(boughtItems);

  }

}
