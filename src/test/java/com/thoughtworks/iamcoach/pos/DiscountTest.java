package com.thoughtworks.iamcoach.pos;


import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class DiscountTest {
  Discount discount = new Discount();

  @Test
  public void get_all_discount_promotions() {
    assertThat(discount.getPromotions().size()).isEqualTo(9);
  }

  @Test
  public void get_promotion_type() {
    String barcode = "ITEM000001";
    assertThat(discount.getPromotionType(barcode)).isEqualTo("buy_two_get_one_free");
  }
}
