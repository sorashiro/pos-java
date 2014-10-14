package com.thoughtworks.iamcoach.pos;

import java.util.ArrayList;
import java.util.List;

public class Pos {

  public List<BoughtItem> handleBarcodes(List<String> cartBarcodes){
    List<BoughtItem> boughtItemList = new ArrayList<BoughtItem>();
    ItemServer itemServer = new ItemServer();
    List<String> uniqueBarcodes = uniqueArray(cartBarcodes);

    for (String uniqueBarcode : uniqueBarcodes) {
      int times = getBarcodeTimes(cartBarcodes, uniqueBarcode);
      String[] barcodes = uniqueBarcode.split("-");
      Double number = 1.00;

      if (barcodes.length == 2) {
        number = Double.parseDouble(barcodes[1]);
      }

      boughtItemList.add(new BoughtItem(itemServer.findItem(barcodes[0]), number * times));
    }
    return boughtItemList;
  }

  private List<String> uniqueArray(List<String> cartBarcodes) {
    List<String> tempArray = new ArrayList<String>();

    for (String barcode : cartBarcodes) {
      if (!tempArray.contains(barcode)) {
        tempArray.add(barcode);
      }
    }
    return tempArray;
  }

  private int getBarcodeTimes(List<String> cartBarcodes, String barcode) {
    int result = 0;

    for (String cartBarcode : cartBarcodes) {
      if (cartBarcode.equals(barcode)) {
        result++;
      }
    }
    return result;
  }
}
