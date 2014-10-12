package com.thoughtworks.iamcoach.pos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    Path file = Paths.get(DISCOUNT_FILE);
    List<String> linesRead = null;
    try {
      linesRead = Files.readAllLines(file);
    } catch (IOException e) {
      e.printStackTrace();
    }

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

    Path file = Paths.get(path);
    List<String> linesRead = null;
    try {
      linesRead = Files.readAllLines(file);
    } catch (IOException e) {
      e.printStackTrace();
    }

    if (linesRead != null) {
      for (String line : linesRead) {
        DiscountItem discountItem = new DiscountItem(line, type);
        arrayList.add(discountItem);
      }
    }
  }

}
