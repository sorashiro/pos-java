package com.thoughtworks.iamcoach.pos;

import java.util.List;

public class PromotionServer {
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

  public Double calculatePromotion(List<BoughtItem> boughtItems) {
    PromotionServer promotionServer = new PromotionServer();
    Double result = 0.00;

    for (BoughtItem boughtItem : boughtItems) {
      String barcode = boughtItem.getBarcode();
      String promotionType = promotionServer.getPromotionType(barcode);
      if (promotionType.equals("buy_two_get_one_free")) {
        result += calculateBuyTwo(boughtItem);
      } else if (promotionType.equals("second_half_price")) {
        result += calculateHalfPrice(boughtItem);
      } else if (promotionType.contains("discount")) {
        result += calculateDiscount(boughtItem, promotionType);
      }
    }
    return result;
  }

  private Double calculateBuyTwo(BoughtItem boughtItem) {
    Double number = boughtItem.getNumber();
    Double payNumber = number - (int) (number / 3);

    return boughtItem.getPrice() * payNumber;
  }

  private Double calculateHalfPrice(BoughtItem boughtItem) {
    Double number = boughtItem.getNumber();
    Double total = boughtItem.getPrice() * number;
    Double discountTotal = (0.5 * boughtItem.getPrice()) * (int) (number / 2);

    return total - discountTotal;
  }

  private Double calculateDiscount(BoughtItem boughtItem, String typeInfo) {
    Double number = boughtItem.getNumber();
    Double discount = Double.parseDouble(typeInfo.split(":")[1]);
    return boughtItem.getPrice() * number * discount / 100;
  }
}
