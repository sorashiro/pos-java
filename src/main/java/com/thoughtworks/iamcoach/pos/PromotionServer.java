package com.thoughtworks.iamcoach.pos;

import java.util.ArrayList;
import java.util.List;

public class PromotionServer {
  static final String BUY_TWO_GET_ONE_FREE = "buy_two_get_one_free";
  static final String SECOND_HALF_PRICE = "second_half_price";
  static final String DISCOUNT = "discount";
  private String promotionType = "none";
  StorageServer storageServer = new StorageServer();

  public String getPromotionType() {
    return this.promotionType;
  }

  public void setPromotionType(String barcode){
    List<Promotion> promotions = storageServer.getPromotions();
    for (Promotion promotion : promotions) {
      if (barcode.equals(promotion.getBarcode())) {
        this.promotionType = promotion.getType();
      }
    }
  }

  public List<PrintItem> calculatePromotion(List<BoughtItem> boughtItems) {
    List<PrintItem> printItemList = new ArrayList<PrintItem>();
    for (BoughtItem boughtItem : boughtItems) {

      setPromotionType(boughtItem.getBarcode());

      printItemList.add(doCalculate(boughtItem));
    }
    return printItemList;
  }


  private PrintItem doCalculate(BoughtItem boughtItem){
    PrintItem result;
    String promotionType = getPromotionType();
    if (promotionType.equals(BUY_TWO_GET_ONE_FREE)) {
      result = calculateBuyTwo(boughtItem);
    } else if (promotionType.equals(SECOND_HALF_PRICE)) {
      result = calculateHalfPrice(boughtItem);
    } else if (promotionType.contains(DISCOUNT)) {
      result = calculateDiscount(boughtItem, promotionType);
    }else {
      result = calculateBoughtItem(boughtItem);
    }
    return result;
  }

  private PrintItem calculateBoughtItem(BoughtItem boughtItem) {
    Double subtotal = boughtItem.getPrice() * boughtItem.getNumber();
    return new PrintItem(boughtItem, subtotal);
  }
  private PrintItem calculateBuyTwo(BoughtItem boughtItem) {

    Double number = boughtItem.getNumber();
    Double payNumber = number - (int) (number / 3);
    Double subtotal = boughtItem.getPrice() * payNumber;
    return new PrintItem(boughtItem, subtotal);
  }

  private PrintItem calculateHalfPrice(BoughtItem boughtItem) {
    Double number = boughtItem.getNumber();
    Double total = boughtItem.getPrice() * number;
    Double discountTotal = (0.5 * boughtItem.getPrice()) * (int) (number / 2);
    Double subtotal = total - discountTotal;
    return new PrintItem(boughtItem, subtotal);
  }

  private PrintItem calculateDiscount(BoughtItem boughtItem, String typeInfo) {
    Double number = boughtItem.getNumber();
    Double discount = Double.parseDouble(typeInfo.split(":")[1]);
    Double subtotal = boughtItem.getPrice() * number * discount / 100;
    return new PrintItem(boughtItem, subtotal);
  }
}
