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

  public Double calculatePromotion(List<BoughtItem> boughtItems){
    Discount discount = new Discount();
    Double result = 0.00;
    for (BoughtItem boughtItem : boughtItems) {
      String barcode = boughtItem.getBarcode();
      String promotionType = discount.getPromotionType(barcode);
      if (promotionType.equals("buy_two_get_one_free")) {
        result += calculateBuyTwo(boughtItem);
      } else if (promotionType.equals("second_half_price")) {
        result += calculateHalfPrice(boughtItem);
      } else if (promotionType.contains("discount")) {
        result += calculateDiscount(boughtItem, promotionType);
      }
    }
    return result;
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

  private Double calculateBuyTwo(BoughtItem boughtItem) {
    Double number = boughtItem.getNumber();
    Double payNumber = number - (int)(number / 3);

    return boughtItem.getPrice() * payNumber;
  }

  private Double calculateHalfPrice(BoughtItem boughtItem) {
    Double number = boughtItem.getNumber();
    Double total = boughtItem.getPrice() * number;
    Double discountTotal = (0.5 * boughtItem.getPrice()) * (number / 2);

    return total - discountTotal;
  }

  private Double calculateDiscount(BoughtItem boughtItem, String typeInfo) {
    Double number = boughtItem.getNumber();
    Double discount = Double.parseDouble(typeInfo.split(":")[1]);
    return boughtItem.getPrice() * number * discount / 100;
  }
}
