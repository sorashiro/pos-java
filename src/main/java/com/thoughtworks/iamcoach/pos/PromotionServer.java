package com.thoughtworks.iamcoach.pos;

import java.util.ArrayList;
import java.util.List;

public class PromotionServer {
  private PromotionType promotionType;
  public String getPromotionType() {
    return promotionType.getPromotionType();
  }

  public void setPromotionType(String barcode){
    promotionType = PromotionType.newType(barcode);
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
    if (promotionType.equals(PromotionType.BUY_TWO_GET_ONE_FREE)) {
      result = calculateBuyTwo(boughtItem);
    } else if (promotionType.equals(PromotionType.SECOND_HALF_PRICE)) {
      result = calculateHalfPrice(boughtItem);
    } else if (promotionType.contains(PromotionType.DISCOUNT)) {
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
