package com.thoughtworks.iamcoach.pos;

public class BuyTwoGetOneFreePromotion extends PromotionType {
  @Override
  public String getPromotionType() {
    return PromotionType.BUY_TWO_GET_ONE_FREE;
  }

  public PrintItem calculate(BoughtItem boughtItem) {

    Double number = boughtItem.getNumber();
    Double payNumber = number - (int) (number / 3);
    Double subtotal = boughtItem.getPrice() * payNumber;
    return new PrintItem(boughtItem, subtotal);
  }
}
