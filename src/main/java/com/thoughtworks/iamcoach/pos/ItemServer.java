package com.thoughtworks.iamcoach.pos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ItemServer {
    private static String ITEMFILE = "src/main/resources/item.txt";

    public static ArrayList getItems() throws IOException {
        ArrayList arrayList = new ArrayList();
        FileReader read = new FileReader(ITEMFILE);
        BufferedReader br = new BufferedReader(read);
        String row;

        while ((row = br.readLine()) != null) {
            String[] stringItem = row.split(" ");
            Item item = new Item(stringItem[0], stringItem[1], stringItem[2], Double.parseDouble(stringItem[3]));
            arrayList.add(item);
        }
        return arrayList;
    }
}