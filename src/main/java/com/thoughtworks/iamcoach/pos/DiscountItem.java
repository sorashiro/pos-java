package com.thoughtworks.iamcoach.pos;

public class DiscountItem {
    private String barcode;
    private String type;

    public DiscountItem(String barcode, String type) {
        this.barcode = barcode;
        this.type = type;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
