package com.thoughtworks.iamcoach.pos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ItemServer {
    private static String ITEMFILE = "src/main/resources/item.txt";

    public ArrayList<String> getBarcodes() throws IOException {
        ArrayList arrayList = new ArrayList<String>();
        FileReader read = new FileReader(ITEMFILE);
        BufferedReader br = new BufferedReader(read);
        String row;

        while ((row = br.readLine()) != null) {
            arrayList.add(row);
        }
        return arrayList;
    }
}
