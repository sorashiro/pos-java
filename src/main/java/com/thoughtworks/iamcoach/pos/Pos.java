package com.thoughtworks.iamcoach.pos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pos {
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

  public List<BoughtItem> handleBarcodes(List<String> cartBarcodes) throws IOException {
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

  public void findPromotion() throws IOException {
    Cart cart = new Cart();
    Discount discount = new Discount();
    List<String> cartItems = cart.getBarcodes();
    List<Promotion> promotions = discount.getPromotions();

    for (String cartItem : cartItems) {
      for (Promotion promotion : promotions) {
        if (cartItem.equals(promotion.getBarcode())) {
//          calculatePromotion(promotion);

        }
      }
    }
  }

  public Double calculatePromotion(List<BoughtItem> boughtItems) throws IOException {
    Discount discount = new Discount();
    for (BoughtItem boughtItem : boughtItems) {
        String barcode = boughtItem.getBarcode();
        String promotionType = discount.getPromotionType(barcode);
    if (promotionType.equals("buy_two_get_one_free")) {
      calculateBuyTwo(boughtItem);
    } else if (promotionType.equals("second_half_price")) {
      calculateHalfPrice(boughtItem);
    } else if (promotionType.contains("discount")) {
      calculateDiscount(boughtItem, promotionType);
    }
    }
    return 30.00;
  }

  private Double calculateBuyTwo(BoughtItem boughtItem) {
    Double number = boughtItem.getNumber();
    Double payNumber = (number / 2) + (number % 2);

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

    return boughtItem.getPrice() * number * discount;
  }
}
