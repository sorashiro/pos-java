package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class ItemServer {
  private static final String ITEM_FILE = "src/main/resources/item.txt";

  private List<Item> getItems() {
    List<Item> arrayList = new ArrayList<Item>();

    List<String> linesRead = FileUtil.textToList(ITEM_FILE);

    for (String line : linesRead) {
      String[] stringItem = line.split(" ");
      Item item = new Item(stringItem[0], stringItem[1], stringItem[2], Double.parseDouble(stringItem[3]));
      arrayList.add(item);
    }
    return arrayList;
  }

  public Item findItem(String barcode){
    List<Item> items = getItems();
    Item result = new Item();
    for (Item item : items) {
      if (barcode.equals(item.getBarcode())) {
        result = item;
      }
    }
    return result;
  }
}
