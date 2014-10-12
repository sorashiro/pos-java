package com.thoughtworks.iamcoach.pos;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Cart {
  private static final String CART_FILE = "src/main/resources/cart.txt";

  public List<String> getBarcodes(){
    Path cartFile = Paths.get(CART_FILE);
    List<String> linesRead = null;
    try {
      linesRead = Files.readAllLines(cartFile);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return linesRead;
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
