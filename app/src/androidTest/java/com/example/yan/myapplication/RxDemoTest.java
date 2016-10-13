package com.example.yan.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yan on 2016/10/8.
 */
public class RxDemoTest {

    @Test
    public void testTest1() throws Exception {
        RxDemo rxDemo = new RxDemo();
        String data = rxDemo.test();
        String d = "hi,I am a observable,I am doing something here";
        assertEquals(d,data);

    }
}