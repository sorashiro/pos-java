package com.thoughtworks.iamcoach.pos;

import java.io.IOException;
import java.util.ArrayList;

public class Pos {
  public void countCart() throws IOException {
    Cart cart = new Cart();
    ArrayList boughtItemList = new ArrayList();
    ArrayList<String> cartBarcodes = cart.getBarcodes();

    for (String barcode : cartBarcodes) {
      int times = 0;

      for (String anotherBarcode : cartBarcodes) {
        if (anotherBarcode.equals(barcode)) {
          times++;
        }
      }

      String[] barcodes = barcode.split(" ");
      BoughtItem boughtItem = new BoughtItem(barcodes[0], Double.parseDouble(barcodes[1]) * times);
      boughtItemList.add(boughtItem);
    }
  }

  private void findPromotion() throws IOException {
    Cart cart = new Cart();
    Discount discount = new Discount();
    ArrayList cartItems = cart.getBarcodes();
    ArrayList promotions = discount.getPromotions();
  }
}
