package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class Discount {
  private static final String DISCOUNT_FILE = "src/main/resources/discount_promotion.txt";
  private static final String BUY_TWO_GET_ONE_FREE_FILE = "src/main/resources/buy_two_get_one_free_promotion.txt";
  private static final String SECOND_HALF_PRICE_PROMOTION_FILE = "src/main/resources/second_half_price_promotion.txt";
  private static List<Promotion> arrayList = new ArrayList<Promotion>();

  public List<Promotion> getPromotions() {
    textToArray(BUY_TWO_GET_ONE_FREE_FILE, "buy_two_get_one_free");
    textToArray(SECOND_HALF_PRICE_PROMOTION_FILE, "second_half_price");

    List<String> linesRead = FileUtil.textToList(DISCOUNT_FILE);

    if (linesRead != null) {
      for (String line : linesRead) {
        String[] cartBarcode = line.split(":");

        Promotion promotion = new Promotion(cartBarcode[0], "discount:" + cartBarcode[1]);
        arrayList.add(promotion);
      }
    }
    return arrayList;
  }

  private void textToArray(String path, String type) {
    List<String> linesRead = FileUtil.textToList(path);

    if (linesRead != null) {
      for (String line : linesRead) {
        Promotion promotion = new Promotion(line, type);
        arrayList.add(promotion);
      }
    }
  }

}
