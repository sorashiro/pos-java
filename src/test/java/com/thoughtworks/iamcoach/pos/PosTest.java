package com.thoughtworks.iamcoach.pos;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class PosTest {
  Pos pos = new Pos();
  @Test
  public  void handle_barcodes_test(){
    List<String> cartBarcodes = new ArrayList<String>();
    cartBarcodes.add("ITEM000001");
    cartBarcodes.add("ITEM000001");
    cartBarcodes.add("ITEM000001");
    cartBarcodes.add("ITEM000001");

    try {
      List<BoughtItem> boughtItemList = pos.handleBarcodes(cartBarcodes);
      BoughtItem boughtItem = boughtItemList.get(0);
      assertThat(boughtItem.getNumber()).isEqualTo(4.00);
      assertThat(boughtItem.getBarcode()).isEqualTo("ITEM000001");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
