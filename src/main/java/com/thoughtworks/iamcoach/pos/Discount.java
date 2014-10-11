package com.thoughtworks.iamcoach.pos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Discount {
  private static String DISCOUNT = "src/main/resources/discount_promotion.txt";
  private static String BUY_TWO_GET_ONE_FREE = "src/main/resources/buy_two_get_one_free_promotion.txt";
  private static String SECOND_HALF_PRICE_PROMOTION = "src/main/resources/second_half_price_promotion.txt";
  private static ArrayList arrayList = new ArrayList();

  public ArrayList getPromotions() throws IOException {
    txtToArray(BUY_TWO_GET_ONE_FREE, "buy_two_get_one_free");
    txtToArray(SECOND_HALF_PRICE_PROMOTION, "second_half_price");

    FileReader discountRead = new FileReader(DISCOUNT);
    BufferedReader discountBr = new BufferedReader(discountRead);
    String row;

    while ((row = discountBr.readLine()) != null) {
      String[] cartBarcode = row.split(":");
      DiscountItem discountItem = new DiscountItem(cartBarcode[0], "discount:" + cartBarcode[1]);
      arrayList.add(discountItem);
    }
    return arrayList;
  }

  private void txtToArray(String path, String type) throws IOException {
    FileReader read = new FileReader(path);
    BufferedReader br = new BufferedReader(read);
    String row;

    while ((row = br.readLine()) != null) {
      DiscountItem discountItem = new DiscountItem(row, type);
      arrayList.add(discountItem);
    }
  }
}
