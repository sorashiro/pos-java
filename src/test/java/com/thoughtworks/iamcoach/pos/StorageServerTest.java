package com.thoughtworks.iamcoach.pos;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;


public class StorageServerTest {

    @Test
    public void get_items_test() {
        StorageServer storageServer = new StorageServer();
        assertThat(storageServer.getItems().size()).isEqualTo(9);
    }
}
