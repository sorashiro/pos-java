package com.thoughtworks.iamcoach.pos;

public class BoughtItem {
  private Item item;
  private double number;

  public BoughtItem(Item item, double number) {
    this.item = item;
    this.number = number;
  }

  public String getBarcode() {
    return item.getBarcode();
  }

  public double getPrice() {
    return item.getPrice();
  }

  public double getNumber() {
    return number;
  }

  public String getName() {
    return item.getName();
  }

  public String getUnit() {
    return item.getUnit();
  }

}
