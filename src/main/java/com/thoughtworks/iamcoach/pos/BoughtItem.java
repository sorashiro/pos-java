package com.thoughtworks.iamcoach.pos;

public class BoughtItem {
  private String barcode;
  private int number;

  public BoughtItem(String barcode, int number) {
    this.barcode = barcode;
    this.number = number;
  }
  public String getBarcode() {
    return barcode;
  }

  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public void addItemNumberByOne() {
    this.number++;
  }
}
