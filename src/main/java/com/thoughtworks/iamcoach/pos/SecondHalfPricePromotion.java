package com.thoughtworks.iamcoach.pos;

public class SecondHalfPricePromotion extends PromotionType {
  @Override
  public String getPromotionType() {
    return PromotionType.SECOND_HALF_PRICE;
  }

  public PrintItem calculate(BoughtItem boughtItem) {
    double number = boughtItem.getNumber();

    double total = boughtItem.getPrice() * number;
    double discountTotal = (0.5 * boughtItem.getPrice()) * (int) (number / 2);

    double subtotal = total - discountTotal;
    return new PrintItem(boughtItem, subtotal);
  }
}
