import com.thoughtworks.iamcoach.pos.*;

import java.util.List;

public class App {
  public static void main(String[] args) {

    Cart cart = new Cart();
    List<String> cartBarcodes = cart.getBarcodes();

    Pos pos = new Pos();
    List<BoughtItem> boughtItems = pos.handleBarcodes(cartBarcodes);

    PromotionServer promotionServer = new PromotionServer();
    Double total = promotionServer.calculatePromotion(boughtItems);
    System.out.println(total);
  }

}
