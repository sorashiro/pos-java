package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.util.FileUtil;

import java.io.*;
import java.util.List;

public class Cart {
  private static final String CART_FILE = "src/main/resources/cart.txt";

  public List<String> getBarcodes() {
    return FileUtil.textToList(CART_FILE);
  }


}
