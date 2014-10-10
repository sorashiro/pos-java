package com.thoughtworks.iamcoach.pos;

public class BoughtItem {
  private String barcode;
  private Double number;

  public BoughtItem(String barcode, Double number) {
    this.barcode = barcode;
    this.number = number;
  }

  public String getBarcode() {
    return barcode;
  }

  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }

  public Double getNumber() {
    return number;
  }

  public void setNumber(Double number) {
    this.number = number;
  }

  public void addItemNumberByOne() {
    this.number += 1;
  }
}
