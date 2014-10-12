package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class Discount {
  private static final String DISCOUNT_FILE = "src/main/resources/discount_promotion.txt";
  private static final String BUY_TWO_GET_ONE_FREE_FILE = "src/main/resources/buy_two_get_one_free_promotion.txt";
  private static final String SECOND_HALF_PRICE_PROMOTION_FILE = "src/main/resources/second_half_price_promotion.txt";
  private static List<DiscountItem> arrayList = new ArrayList<DiscountItem>();

  public List<DiscountItem> getPromotions() {
    textToArray(BUY_TWO_GET_ONE_FREE_FILE, "buy_two_get_one_free");
    textToArray(SECOND_HALF_PRICE_PROMOTION_FILE, "second_half_price");

    List<String> linesRead = FileUtil.textToList(DISCOUNT_FILE);

    if (linesRead != null) {
      for (String line : linesRead) {
        String[] cartBarcode = line.split(":");

        DiscountItem discountItem = new DiscountItem(cartBarcode[0], "discount:" + cartBarcode[1]);
        arrayList.add(discountItem);
      }
    }
    return arrayList;
  }

  private void textToArray(String path, String type) {
    List<String> linesRead = FileUtil.textToList(path);

    if (linesRead != null) {
      for (String line : linesRead) {
        DiscountItem discountItem = new DiscountItem(line, type);
        arrayList.add(discountItem);
      }
    }
  }

}
