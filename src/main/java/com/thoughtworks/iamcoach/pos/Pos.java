package com.thoughtworks.iamcoach.pos;

import java.io.IOException;
import java.util.ArrayList;

public class Pos {
  public ArrayList countCart() throws IOException {
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
    return boughtItemList;
  }

  private void findPromotion() throws IOException {
    Cart cart = new Cart();
    Discount discount = new Discount();
    ArrayList<String> cartItems = cart.getBarcodes();
    ArrayList<DiscountItem> promotions = discount.getPromotions();

    for(String cartItem : cartItems){
      for(DiscountItem promotion : promotions){
        if(cartItem.equals(promotion.getBarcode())){
          calculatePromotion(promotion);
          
        }
      }
    }
  }

  private void calculatePromotion(DiscountItem promotion) throws IOException {
    ItemServer itemServer = new ItemServer();
    Cart cart = new Cart();
    BoughtItem boughtItem = cart.findItemNumber(promotion.getBarcode());
    Item item = itemServer.findItem(promotion.getBarcode());

    if(promotion.getType().equals("buy_two_get_one_free")) {
      calculateBuyTwo(item, boughtItem);
    }
    else if(promotion.getType().equals("second_half_price")) {
      calculateHalfPrice(item, boughtItem);
    }
    else if(promotion.getType().contains("discount")) {
      calculateDiscount(item, boughtItem, promotion.getType());
    }
  }

  private Double calculateBuyTwo(Item item, BoughtItem boughtItem) {
    Double number = boughtItem.getNumber();
    Double payNumber = (number / 2) + (number % 2);

    return item.getPrice() * payNumber;
  }

  private Double calculateHalfPrice(Item item, BoughtItem boughtItem) {
    Double number = boughtItem.getNumber();
    Double total = item.getPrice() * number;
    Double discountTotal = (0.5 * item.getPrice()) * (number / 2);

    return total - discountTotal;
  }

  private Double calculateDiscount(Item item, BoughtItem boughtItem, String typeInfo) {
    Double number = boughtItem.getNumber();
    Double discount = Double.parseDouble(typeInfo.split(":")[1]);

    return item.getPrice() * number * discount;
  }
}
