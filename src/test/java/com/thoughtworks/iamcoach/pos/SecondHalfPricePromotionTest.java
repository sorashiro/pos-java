package com.thoughtworks.iamcoach.pos;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class SecondHalfPricePromotionTest {

  SecondHalfPricePromotion secondHalfPricePromotion = new SecondHalfPricePromotion();

  @Test
  public void calculate_test() {
    Item item = new Item("ITEM000002", "apple", "kg", 10.00);
    BoughtItem boughtItem = new BoughtItem(item, 5.0);
    assertThat(secondHalfPricePromotion.calculate(boughtItem).getSubtotal()).isEqualTo(40.0);

    BoughtItem boughtItem1 = new BoughtItem(item, 3.0);
    assertThat(secondHalfPricePromotion.calculate(boughtItem1).getSubtotal()).isEqualTo(25.0);

    BoughtItem boughtItem2 = new BoughtItem(item, 1.0);
    assertThat(secondHalfPricePromotion.calculate(boughtItem2).getSubtotal()).isEqualTo(10.0);

    BoughtItem boughtItem3 = new BoughtItem(item, 0.0);
    assertThat(secondHalfPricePromotion.calculate(boughtItem3).getSubtotal()).isEqualTo(0.0);
  }
}
