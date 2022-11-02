package com.guat.myosotis.util;

import org.junit.Test;

public class MD5Test {
    @Test
    public void MD5AddSaltTest() {
        String password = "123456";
        System.out.println(MD5.MD5AddSalt(password));
    }
}
