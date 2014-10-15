package com.thoughtworks.iamcoach.pos;

import java.util.List;

public abstract class PromotionType {
  abstract String getPromotionType();
  static final String BUY_TWO_GET_ONE_FREE = "buy_two_get_one_free";
  static final String SECOND_HALF_PRICE = "second_half_price";
  static final String DISCOUNT = "discount";
  static StorageServer storageServer = new StorageServer();

  public static PromotionType newType (String barcode){
    PromotionType promotionType = new SecondHalfPricePromotion();
    List<Promotion> promotions = storageServer.getPromotions();

    for (Promotion promotion : promotions) {
      if (barcode.equals(promotion.getBarcode())) {

        String type = promotion.getType();
        String[] typeArray = type.split(":");


        if(typeArray[0].equals(BUY_TWO_GET_ONE_FREE)) {
          promotionType = new BuyTwoGetOneFreePromotion();
        }else if(typeArray[0].equals(SECOND_HALF_PRICE)) {
          promotionType = new SecondHalfPricePromotion();
        }
        else if(typeArray[0].equals(DISCOUNT)) {
          promotionType = new DiscountPromition(type);
        }

      }
    }

    return promotionType;
  }

  public PrintItem doCalculate(BoughtItem boughtItem){
    PrintItem result;
    String promotionType = getPromotionType();
    if (promotionType.equals(PromotionType.BUY_TWO_GET_ONE_FREE)) {
      result = calculateBuyTwo(boughtItem);
    } else if (promotionType.equals(PromotionType.SECOND_HALF_PRICE)) {
      result = calculateHalfPrice(boughtItem);
    } else if (promotionType.contains(PromotionType.DISCOUNT)) {
      throw new RuntimeException("should be being overridden");
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
