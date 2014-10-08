package com.thoughtworks.cart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class cart {

    private static String  CARTFILE = "src/main/java/com/thoughtworks/cart/cart.txt";

    public static ArrayList getBarcodes() throws IOException {
        ArrayList arrayList = new ArrayList();
        FileReader read = new FileReader(CARTFILE);
        BufferedReader br = new BufferedReader(read);
        String row;

        while((row = br.readLine()) != null) {
            arrayList.add(row);
        }
        return arrayList;
    }

    public static void main(String[] args) throws IOException {
        getBarcodes();
    }
}
