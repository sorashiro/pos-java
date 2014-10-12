package com.thoughtworks.iamcoach.pos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pos {
  private List uniqueArray(List<String> cartBarcodes){
    List<String> tempArray = new ArrayList<String>();
    for(String barcode : cartBarcodes){
      if(!tempArray.contains(barcode)){
        tempArray.add(barcode);
      }
    }
    return tempArray;
  }

  private int getBarcodeTimes(List<String> cartBarcodes, String barcode){
    int result = 0;
    for (String cartBarcode : cartBarcodes) {
      if (cartBarcode.equals(barcode)) {
        result++;
      }
    }
    return result;
  }

  public ArrayList handleBarcodes(List<String> cartBarcodes) throws IOException {
    ArrayList boughtItemList = new ArrayList();

    List<String> uniqueBarcodes = uniqueArray(cartBarcodes);
    for (String uniqueBarcode : uniqueBarcodes) {
      int times = getBarcodeTimes(cartBarcodes, uniqueBarcode);
      String[] barcodes = uniqueBarcode.split("-");
      Double number = 1.00;

      if(barcodes.length == 2){
        number = Double.parseDouble(barcodes[1]);
      }

      boughtItemList.add(new BoughtItem(barcodes[0], number * times));
    }
    return boughtItemList;
  }

  private void findPromotion() throws IOException {
    Cart cart = new Cart();
    Discount discount = new Discount();
    List<String> cartItems = cart.getBarcodes();
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
