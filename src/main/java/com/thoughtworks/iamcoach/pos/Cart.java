package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.util.FileUtil;

import java.io.*;
import java.util.List;

public class Cart {
  private static final String CART_FILE = "src/main/resources/cart.txt";

  public List<String> getBarcodes(){
    List<String> linesRead = FileUtil.textToList(CART_FILE);;
    return linesRead;
  }

  public BoughtItem findItemNumber(String  barcode) throws IOException {
    Pos pos = new Pos();
    BoughtItem result = new BoughtItem();
//    ArrayList<BoughtItem> boughtItems = pos.countCart();
//    for(BoughtItem boughtItem : boughtItems ){
//        if (barcode.equals(boughtItem.getBarcode())){
//            result = boughtItem;
//        }
//    }
      return  result;
  }

}
