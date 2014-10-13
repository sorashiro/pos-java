package com.thoughtworks.iamcoach.pos;

public class Item {
  private String barcode;
  private String name;
  private String unit;
  private Double price;

  public Item() {}

  public Item(String barcode, String name, String unit, Double price) {
    this.setBarcode(barcode);
    this.setName(name);
    this.setUnit(unit);
    this.setPrice(price);
  }

  public String getBarcode() {
    return barcode;
  }

  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }
}
