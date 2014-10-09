package com.thoughtworks.iamcoach.pos.cart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class cart {

    public  ArrayList getBarcodes() throws IOException {
        ArrayList arrayList = new ArrayList<String>();
        FileReader read = new FileReader("src/main/java/resources/cart.txt");
        BufferedReader br = new BufferedReader(read);
        String row;

        while((row = br.readLine()) != null) {
            arrayList.add(row);
        }
        return arrayList;
    }
}
