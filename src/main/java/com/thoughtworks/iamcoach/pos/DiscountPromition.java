package com.thoughtworks.iamcoach.pos;

public class DiscountPromition extends PromotionType{
  private String type;
  public DiscountPromition(String type){
    this.type = type;
  }
  @Override
  String getPromotionType() {
    return type;
  }
}
