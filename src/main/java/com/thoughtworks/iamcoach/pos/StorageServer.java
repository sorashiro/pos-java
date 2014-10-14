package com.thoughtworks.iamcoach.pos;

import com.thoughtworks.iamcoach.pos.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class StorageServer {
    private static final String ITEM_FILE = "src/main/resources/item.txt";

    public List<Item> getItems() {
        List<Item> arrayList = new ArrayList<Item>();

        List<String> linesRead = FileUtil.textToList(ITEM_FILE);

        for (String line : linesRead) {
            String[] stringItem = line.split(" ");
            Item item = new Item(stringItem[0], stringItem[1], stringItem[2], Double.parseDouble(stringItem[3]));
            arrayList.add(item);
        }
        return arrayList;
    }


}
