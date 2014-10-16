package com.thoughtworks.iamcoach.pos;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class PromotionTypeTest {
  PromotionType promotionType = new PromotionType();

  @Test
  public void calculate_test() {
    Item item = new Item("ITEM000002", "apple", "kg", 10.00);
    BoughtItem boughtItem = new BoughtItem(item, 5.0);
    assertThat(promotionType.calculate(boughtItem).getSubtotal()).isEqualTo(50.0);
  }
}
