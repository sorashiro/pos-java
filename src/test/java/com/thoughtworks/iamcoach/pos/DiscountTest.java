package com.thoughtworks.iamcoach.pos;


import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class DiscountTest {
  Discount discount = new Discount();

  @Test
  public void get_all_discount_promotions() {
    assertThat(discount.getPromotions().size()).isEqualTo(9);
  }
}
