package com.thoughtworks.iamcoach.pos;

public class SecondHalfPricePromotion extends PromotionType {
  @Override
  String getPromotionType() {
    return PromotionType.SECOND_HALF_PRICE;
  }

  public PrintItem doCalculate(BoughtItem boughtItem) {
    Double number = boughtItem.getNumber();
    Double total = boughtItem.getPrice() * number;
    Double discountTotal = (0.5 * boughtItem.getPrice()) * (int) (number / 2);
    Double subtotal = total - discountTotal;
    return new PrintItem(boughtItem, subtotal);
  }
}
