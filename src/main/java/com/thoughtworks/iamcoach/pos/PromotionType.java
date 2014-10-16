package com.thoughtworks.iamcoach.pos;

import java.util.List;

public class PromotionType {
  public String getPromotionType() {
    return "";
  }

  static final String BUY_TWO_GET_ONE_FREE = "buy_two_get_one_free";
  static final String SECOND_HALF_PRICE = "second_half_price";
  static final String DISCOUNT = "discount";
  static StorageServer storageServer = new StorageServer();

  public static PromotionType newPromotionType(String barcode) {
    PromotionType promotionType = new SecondHalfPricePromotion();
    List<Promotion> promotions = storageServer.getPromotions();

    for (Promotion promotion : promotions) {
      if (barcode.equals(promotion.getBarcode())) {

        String type = promotion.getType();
        promotionType = newPromotionByType(type);
      }
    }

    return promotionType;
  }

  private static PromotionType newPromotionByType(String type) {
    PromotionType promotionType = new PromotionType();
    String[] typeArray = type.split(":");

    if (typeArray[0].equals(BUY_TWO_GET_ONE_FREE)) {
      promotionType = new BuyTwoGetOneFreePromotion();
    } else if (typeArray[0].equals(SECOND_HALF_PRICE)) {
      promotionType = new SecondHalfPricePromotion();
    } else if (typeArray[0].equals(DISCOUNT)) {
      promotionType = new DiscountPromotion(type);
    }

    return promotionType;
  }

  public PrintItem calculate(BoughtItem boughtItem) {
    Double subtotal = boughtItem.getPrice() * boughtItem.getNumber();
    return new PrintItem(boughtItem, subtotal);
  }
}
