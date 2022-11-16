package com.example.myapplication;

import static org.junit.Assert.*;

import org.junit.Test;

public class Home1Test {

    @Test
    public void onCreate() {
        assertNotSame(actualString(), "perro");
        assertNotSame("gato", actualString());
    }

    private String actualString() {
        return "";
    }

}