package com.thoughtworks.iamcoach.pos;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;


public class StorageServerTest {
  StorageServer storageServer = new StorageServer();

  @Test
  public void get_items_test() {
    assertThat(storageServer.getItems().size()).isEqualTo(9);
  }

  @Test
  public void get_cart_barcodes_test() {
    assertThat(storageServer.getCartBarcodes().size()).isEqualTo(9);
  }

  @Test
  public void get_promotions_test() {
    assertThat(storageServer.getPromotions().size()).isEqualTo(9);
  }
}
