package com.thoughtworks.iamcoach.pos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Cart {
  private static final String CART_FILE = "src/main/resources/cart.txt";

  public ArrayList<String> getBarcodes() throws IOException {
    ArrayList arrayList = new ArrayList<String>();
    FileReader read = new FileReader(CART_FILE);
    BufferedReader br = new BufferedReader(read);
    String row;

    while ((row = br.readLine()) != null) {
      arrayList.add(row);
    }
    return arrayList;
  }

  public BoughtItem findItemNumber(String  barcode) throws IOException {
    Pos pos = new Pos();
    BoughtItem result = new BoughtItem();
    ArrayList<BoughtItem> boughtItems = pos.countCart();
    for(BoughtItem boughtItem : boughtItems ){
        if (barcode.equals(boughtItem.getBarcode())){
            result = boughtItem;
        }
    }
      return  result;
  }

}
