package com.thoughtworks.iamcoach.pos;

public class DiscountPromition extends PromotionType{

  @Override
  String getPromotionType() {
    return PromotionServer.DISCOUNT;
  }
}
