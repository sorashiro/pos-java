package com.thoughtworks.iamcoach.pos;


import org.junit.Test;

import java.io.IOException;

import static org.fest.assertions.api.Assertions.assertThat;

public class DiscountTest {
  Discount discount = new Discount();

  @Test
  public void get_all_discount_promotions(){
    try {
      assertThat(discount.getPromotions().size()).isEqualTo(9);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
