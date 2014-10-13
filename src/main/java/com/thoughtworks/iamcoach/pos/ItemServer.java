package com.thoughtworks.iamcoach.pos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ItemServer {
  private static final String ITEM_FILE = "src/main/resources/item.txt";

  private ArrayList getItems() throws IOException {
    ArrayList arrayList = new ArrayList();
    FileReader read = new FileReader(ITEM_FILE);
    BufferedReader br = new BufferedReader(read);
    String row;

    while ((row = br.readLine()) != null) {
      String[] stringItem = row.split(" ");
      Item item = new Item(stringItem[0], stringItem[1], stringItem[2], Double.parseDouble(stringItem[3]));
      arrayList.add(item);
    }
    return arrayList;
  }

  public Item findItem(String barcode) throws IOException {
    ArrayList<Item> items = getItems();
    Item result = new Item();
    for (Item item : items) {
      if (barcode.equals(item.getBarcode())) {
        result = item;
      }
    }
    return result;
  }
}
