import com.thoughtworks.iamcoach.pos.*;

import java.util.List;

public class App {
  public static void main(String[] args) {

    StorageServer storageServer = new StorageServer();
    List<String> cartBarcodes = storageServer.getCartBarcodes();

    Pos pos = new Pos();
    List<BoughtItem> boughtItems = pos.handleBarcodes(cartBarcodes);

    PromotionServer promotionServer = new PromotionServer();
    List<PrintItem> printItemList = promotionServer.calculatePromotion(boughtItems);
    Output.printShoppingList(printItemList);
  }

}
