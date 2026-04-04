package me.graceteng;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class HelloWorldTest {

  @Test
  void hello() {
    assertThat(HelloWorld.hello()).isEqualTo("Hello World!");
  }
}
