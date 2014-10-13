package com.thoughtworks.iamcoach.pos;

public class BoughtItem {
  private Item item;
  private Double number;

  public BoughtItem(Item item, Double number) {
    this.item = item;
    this.number = number;
  }

  public BoughtItem() {
  }

  public String getBarcode() {
      return item.getBarcode();
  }

  public Item getItem() {
    return item;
  }

  public Double getPrice() {
    return item.getPrice();
  }

  public Double getNumber() {
    return number;
  }


}
