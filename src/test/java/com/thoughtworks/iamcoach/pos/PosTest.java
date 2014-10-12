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
    List<BoughtItem> boughtItemList = new ArrayList<BoughtItem>();
    boughtItemList.add(new BoughtItem("ITEM000001", 1.00));
    List<String> cartBarcodes = new ArrayList<String>();
    cartBarcodes.add("ITEM000001");
    try {
      assertThat(pos.handleBarcodes(cartBarcodes)).isEqualTo(boughtItemList);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
