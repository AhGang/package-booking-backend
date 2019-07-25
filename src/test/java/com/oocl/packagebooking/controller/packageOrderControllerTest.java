package com.oocl.packagebooking.controller;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class packageOrderControllerTest {
    @Test
    public void should_get_hello_world_when_getHelloWorld() {
        // GIVEN
        PackageOrderController packageOrderController = new PackageOrderController();

        // WHEN
        String helloWorld = packageOrderController.getHelloWorld();

        // THEN
        Assertions.assertEquals("Hello world", helloWorld);
    }
}