package com.thoughtworks.iamcoach.pos;

import java.util.ArrayList;
import java.util.List;

public class PromotionServer {
  private PromotionType promotionType;

  public void setPromotionType(String barcode) {
    this.promotionType = PromotionType.newPromotionType(barcode);
  }

  public List<PrintItem> calculatePromotion(List<BoughtItem> boughtItems) {
    List<PrintItem> printItemList = new ArrayList<PrintItem>();
    for (BoughtItem boughtItem : boughtItems) {

      setPromotionType(boughtItem.getBarcode());
      printItemList.add(promotionType.calculate(boughtItem));
    }
    return printItemList;
  }

}
