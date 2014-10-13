package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class Discount {
  private static final String DISCOUNT_FILE = "src/main/resources/discount_promotion.txt";
  private static final String BUY_TWO_GET_ONE_FREE_FILE = "src/main/resources/buy_two_get_one_free_promotion.txt";
  private static final String SECOND_HALF_PRICE_PROMOTION_FILE = "src/main/resources/second_half_price_promotion.txt";

  public List<Promotion> getPromotions() {
    List<Promotion> arrayList = new ArrayList<Promotion>();

    List<Promotion> arrayList1 = getPromotionFromFile(BUY_TWO_GET_ONE_FREE_FILE, "buy_two_get_one_free");
    arrayList.addAll(arrayList1);

    List<Promotion> arrayList2 = getPromotionFromFile(SECOND_HALF_PRICE_PROMOTION_FILE, "second_half_price");
    arrayList.addAll(arrayList2);

    arrayList.addAll(getDisconutPromotion(DISCOUNT_FILE));

    return arrayList;
  }

  public String getPromotionType(String barcode) {
    List<Promotion> promotions = getPromotions();
    String result = "";
    for (Promotion promotion : promotions) {
      if (barcode.equals(promotion.getBarcode())) {
        result = promotion.getType();
      }
    }
    return result;
  }

  private List<Promotion> getDisconutPromotion(String path) {
    List<String> linesRead = FileUtil.textToList(path);
    List<Promotion> arrayList = new ArrayList<Promotion>();
    if (linesRead != null) {
      for (String line : linesRead) {
        String[] cartBarcode = line.split(":");

        Promotion promotion = new Promotion(cartBarcode[0], "discount:" + cartBarcode[1]);
        arrayList.add(promotion);
      }
    }
    return arrayList;
  }

  private List<Promotion> getPromotionFromFile(String path, String type) {
    List<String> linesRead = FileUtil.textToList(path);
    List<Promotion> arrayList = new ArrayList<Promotion>();
    if (linesRead != null) {
      for (String line : linesRead) {
        Promotion promotion = new Promotion(line, type);
        arrayList.add(promotion);
      }
    }
    return arrayList;
  }
}
