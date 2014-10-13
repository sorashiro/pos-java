package com.thoughtworks.iamcoach.pos;

import org.junit.Test;

import java.io.IOException;

import static org.fest.assertions.api.Assertions.assertThat;

public class ItemServerTest {
    ItemServer itemServer = new ItemServer();
    @Test
    public void find_item_test() {
        String barcode = "ITEM000001";
        Item item = new Item("ITEM000001", "可口可乐", "瓶", 3.50);
        try {
            assertThat(itemServer.findItem(barcode).getBarcode()).isEqualTo("ITEM000001");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

