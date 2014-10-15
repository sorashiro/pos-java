package com.thoughtworks.iamcoach.pos;

public class SecondHalfPricePromotion extends PromotionType{
  @Override
  String getPromotionType() {
    return PromotionServer.SECOND_HALF_PRICE;
  }
}
