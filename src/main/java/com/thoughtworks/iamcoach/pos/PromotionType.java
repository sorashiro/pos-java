package com.thoughtworks.iamcoach.pos;

import java.util.List;

public abstract class PromotionType {
  abstract String getPromotionType();
  static final String BUY_TWO_GET_ONE_FREE = "buy_two_get_one_free";
  static final String SECOND_HALF_PRICE = "second_half_price";
  static final String DISCOUNT = "discount";
  static StorageServer storageServer = new StorageServer();

  public static PromotionType newType (String barcode){
    PromotionType promotionType = new DiscountPromition();
    List<Promotion> promotions = storageServer.getPromotions();
    for (Promotion promotion : promotions) {
      if (barcode.equals(promotion.getBarcode())) {
        String type = promotion.getType();
        if(type.equals(BUY_TWO_GET_ONE_FREE)) {
          promotionType = new BuyTwoGetOneFreePromotion();
        }else if(type.equals(SECOND_HALF_PRICE)) {
          promotionType = new SecondHalfPricePromotion();
        }
        else if(type.equals(DISCOUNT)) {
          promotionType = new DiscountPromition();
        }
      }
    }
    return promotionType;
  }

}
