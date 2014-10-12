package com.thoughtworks.iamcoach.pos;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class CartTest {

  @Test
  public void cart_file_should_be_read_correct(){
    Cart cart = new Cart();
    assertThat(cart.getBarcodes().size()).isEqualTo(9);
  }
}
