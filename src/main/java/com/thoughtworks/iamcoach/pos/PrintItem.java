package com.thoughtworks.iamcoach.pos;

public class PrintItem {
  private BoughtItem boughtItem;
  private Double subtotal;

  public PrintItem(BoughtItem boughtItem, Double subtotal) {
    this.setBoughtItem(boughtItem);
    this.setSubtotal(subtotal);
  }

  public BoughtItem getBoughtItem() {
    return boughtItem;
  }

  public void setBoughtItem(BoughtItem boughtItem) {
    this.boughtItem = boughtItem;
  }

  public Double getSubtotal() {
    return subtotal;
  }

  public void setSubtotal(Double subtotal) {
    this.subtotal = subtotal;
  }
}
