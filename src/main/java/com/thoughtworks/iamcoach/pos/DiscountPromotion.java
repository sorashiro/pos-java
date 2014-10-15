package com.thoughtworks.iamcoach.pos;

public class DiscountPromotion extends PromotionType {
  private String type;

  public DiscountPromotion(String type) {
    this.type = type;
  }

  @Override
  String getPromotionType() {
    return type;
  }

  public PrintItem doCalculate(BoughtItem boughtItem) {
    Double number = boughtItem.getNumber();
    Double discount = Double.parseDouble(type.split(":")[1]);
    Double subtotal = boughtItem.getPrice() * number * discount / 100;
    return new PrintItem(boughtItem, subtotal);
  }
}
