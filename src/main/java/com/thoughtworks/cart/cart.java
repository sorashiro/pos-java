package com.thoughtworks.cart;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class cart {
    public static String getBarcodes() throws IOException {
        FileReader read = new FileReader("src/main/java/com/thoughtworks/cart/cart.txt");
        BufferedReader br = new BufferedReader(read);
        String row;
        while((row = br.readLine()) != null) {
            System.out.println(row);
        }

        return null;

    }

    public static void main(String[] args) throws IOException {
        getBarcodes();
    }
}
