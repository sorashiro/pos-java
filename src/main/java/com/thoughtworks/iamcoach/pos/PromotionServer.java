package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class PromotionServer {
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

    public Double calculatePromotion(List<BoughtItem> boughtItems){
        PromotionServer promotionServer = new PromotionServer();
        Double result = 0.00;
        for (BoughtItem boughtItem : boughtItems) {
            String barcode = boughtItem.getBarcode();
            String promotionType = promotionServer.getPromotionType(barcode);
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

    private Double calculateBuyTwo(BoughtItem boughtItem) {
        Double number = boughtItem.getNumber();
        Double payNumber = number - (int)(number / 3);

        return boughtItem.getPrice() * payNumber;
    }

    private Double calculateHalfPrice(BoughtItem boughtItem) {
        Double number = boughtItem.getNumber();
        Double total = boughtItem.getPrice() * number;
        Double discountTotal = (0.5 * boughtItem.getPrice()) * (int)(number / 2);

        return total - discountTotal;
    }

    private Double calculateDiscount(BoughtItem boughtItem, String typeInfo) {
        Double number = boughtItem.getNumber();
        Double discount = Double.parseDouble(typeInfo.split(":")[1]);
        return boughtItem.getPrice() * number * discount / 100;
    }
}
