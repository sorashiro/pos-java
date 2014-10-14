package com.thoughtworks.iamcoach.pos;

import java.util.ArrayList;
import java.util.List;

public class PromotionServer {
  private static final String BUY_TWO_GET_ONE_FREE = "buy_two_get_one_free";
  private static final String SECOND_HALF_PRICE = "second_half_price";
  private static final String DISCOUNT = "discount";

  StorageServer storageServer = new StorageServer();

  public String getPromotionType(String barcode) {
    List<Promotion> promotions = storageServer.getPromotions();
    String result = "";

    for (Promotion promotion : promotions) {
      if (barcode.equals(promotion.getBarcode())) {
        result = promotion.getType();
      }
    }
    return result;
  }

  public List<PrintItem> calculatePromotion(List<BoughtItem> boughtItems) {
    PrintItem result = new PrintItem();
    List<PrintItem> printItemList = new ArrayList<PrintItem>();
    for (BoughtItem boughtItem : boughtItems) {
      String barcode = boughtItem.getBarcode();
      String promotionType = getPromotionType(barcode);
      if (promotionType.equals(BUY_TWO_GET_ONE_FREE)) {
        result = calculateBuyTwo(boughtItem);
      } else if (promotionType.equals(SECOND_HALF_PRICE)) {
        result = calculateHalfPrice(boughtItem);
      } else if (promotionType.contains(DISCOUNT)) {
        result = calculateDiscount(boughtItem, promotionType);
      }
        printItemList.add(result);
    }
    return printItemList;
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
