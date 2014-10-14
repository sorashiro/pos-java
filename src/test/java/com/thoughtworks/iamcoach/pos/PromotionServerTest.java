package com.thoughtworks.iamcoach.pos;


import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class PromotionServerTest {
  PromotionServer promotionServer = new PromotionServer();

  @Test
  public void get_all_discount_promotions() {
    assertThat(promotionServer.getPromotions().size()).isEqualTo(9);
  }

  @Test
  public void get_promotion_type() {
    String barcode = "ITEM000001";
    assertThat(promotionServer.getPromotionType(barcode)).isEqualTo("buy_two_get_one_free");
  }
}
