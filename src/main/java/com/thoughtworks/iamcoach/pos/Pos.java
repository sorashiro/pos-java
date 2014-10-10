package com.thoughtworks.iamcoach.pos;

import java.io.IOException;
import java.util.ArrayList;

public class Pos {
  public void coutCart() throws IOException {
    Cart cart = new Cart();
    ArrayList boughtItemList = new ArrayList();
    ArrayList<String> barcodes = cart.getBarcodes();

    for(String barcode : barcodes){
      int times = 0;

      for (String anotherBarcode : barcodes){
        if(anotherBarcode.equals(barcode)){
          times++;
        }
      }

      String[] barcodeAndnumber = barcode.split(" ");
      BoughtItem boughtItem = new BoughtItem(barcodeAndnumber[0], Double.parseDouble(barcodeAndnumber[1]) *times);
      boughtItemList.add(boughtItem);
    }
  }
}
