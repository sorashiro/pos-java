package com.thoughtworks.iamcoach.pos;

import java.util.List;

public class ItemServer {

  StorageServer storageServer = new StorageServer();

  public Item findItem(String barcode) {
    List<Item> items = storageServer.getItems();

    Item result = new Item();
    for (Item item : items) {
      if (barcode.equals(item.getBarcode())) {
        result = item;
        break;
      }
    }

    return result;
  }
}
