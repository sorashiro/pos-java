package com.thoughtworks.iamcoach.pos;

public class PrintItem {
  private String name;
  private String unit;
  private Double price;
  private String barcode;
  private Double number;
  private Double subtotal;

  public PrintItem(BoughtItem boughtItem, Double subtotal) {
    this.setSubtotal(subtotal);
    this.name = boughtItem.getName();
    this.unit = boughtItem.getUnit();
    this.price = boughtItem.getPrice();
    this.barcode = boughtItem.getBarcode();
    this.number = boughtItem.getNumber();
  }

  public Double getSubtotal() {
    return subtotal;
  }

  public void setSubtotal(Double subtotal) {
    this.subtotal = subtotal;
  }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public Double getPrice() {
        return price;
    }

    public String getBarcode() {
        return barcode;
    }

    public Double getNumber() {
        return number;
    }
}
