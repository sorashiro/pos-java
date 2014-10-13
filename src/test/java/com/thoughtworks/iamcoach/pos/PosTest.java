package com.thoughtworks.iamcoach.pos;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class PosTest {
  Pos pos = new Pos();

  @Test
  public void handle_barcodes_test() {
    List<String> cartBarcodes = new ArrayList<String>();
    cartBarcodes.add("ITEM000001");
    cartBarcodes.add("ITEM000001");
    cartBarcodes.add("ITEM000001");
    cartBarcodes.add("ITEM000001");
    cartBarcodes.add("ITEM000006-2.00");
    cartBarcodes.add("ITEM000006-2.00");


      List<BoughtItem> boughtItemList = pos.handleBarcodes(cartBarcodes);
      BoughtItem boughtItem1 = boughtItemList.get(0);
      BoughtItem boughtItem2 = boughtItemList.get(1);

      assertThat(boughtItem1.getNumber()).isEqualTo(4.00);
      assertThat(boughtItem1.getBarcode()).isEqualTo("ITEM000001");

      assertThat(boughtItem2.getNumber()).isEqualTo(4.00);
      assertThat(boughtItem2.getBarcode()).isEqualTo("ITEM000006");

  }

  @Test
  public void calculate_promotion_test() {
    List<BoughtItem> boughtItems = new ArrayList<BoughtItem>();
    Item item1 = new Item("ITEM000002", "apple", "kg", 10.00);
    Item item2 = new Item("ITEM000001", "book", "本", 10.00);
    Item item3 = new Item("ITEM000007", "milk", "盒", 10.00);

    boughtItems.add(new BoughtItem(item1, 4.00));
    boughtItems.add(new BoughtItem(item2, 3.00));
    boughtItems.add(new BoughtItem(item3, 2.00));

      assertThat(pos.calculatePromotion(boughtItems)).isEqualTo(65.00);
  }
}
