package com.thoughtworks.iamcoach.pos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Discount {
    private static String DISCOUNT = "src/main/java/resources/discount_promotion.txt";
    private static String BUY_TWO_GET_ONE_FREE = "src/main/java/resources/buy_two_get_one_promotion.txt";
    private static String SECOND_HALF_PRICE_PROMOTION = "src/main/java/resources/second_half_price_promotion.txt";
    private ArrayList arrayList = new ArrayList();

    public void getPromotions () throws IOException {
        FileReader discountRead = new FileReader(DISCOUNT);
        FileReader buyTwoRead = new FileReader(BUY_TWO_GET_ONE_FREE);
        FileReader halfPriceRead = new FileReader(SECOND_HALF_PRICE_PROMOTION);

        BufferedReader discountBr = new BufferedReader(discountRead);
        BufferedReader buyTwoBr = new BufferedReader(buyTwoRead);
        BufferedReader halfPriceBr = new BufferedReader(halfPriceRead);

        String row;

        while ((row = discountBr.readLine()) != null) {
            String[] cartBarcode = row.split(":");
            DiscountItem discountItem = new DiscountItem(cartBarcode[0], "discount" + cartBarcode[1]);
            arrayList.add(discountItem);
        }
        while ((row = buyTwoBr.readLine()) != null) {
            DiscountItem discountItem = new DiscountItem(row, "buy_two_get_one_free");
            arrayList.add(discountItem);
        }
        while ((row = halfPriceBr.readLine()) != null) {
            DiscountItem discountItem = new DiscountItem(row, "second_half_price");
            arrayList.add(discountItem);
        }
    }


}
