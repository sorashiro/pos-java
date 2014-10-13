package com.thoughtworks.iamcoach.pos;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class ItemServerTest {
  ItemServer itemServer = new ItemServer();

  @Test
  public void find_item_test() {
    String barcode = "ITEM000001";
    assertThat(itemServer.findItem(barcode).getBarcode()).isEqualTo("ITEM000001");
    assertThat(itemServer.findItem(barcode).getName()).isEqualTo("可口可乐");
    assertThat(itemServer.findItem(barcode).getPrice()).isEqualTo(3.50);
    assertThat(itemServer.findItem(barcode).getUnit()).isEqualTo("瓶");
  }
}

