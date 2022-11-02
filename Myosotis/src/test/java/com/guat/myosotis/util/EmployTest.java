package com.guat.myosotis.util;

import com.guat.myosotis.bean.Employ;
import org.junit.Test;

public class EmployTest {
    @Test
    public void test() {
        Employ employ = new Employ();
        employ.setHireDate("2002-09-07");
        employ.setDeptId("1001");
        System.out.println(EmployIdUtil.parse(EmployIdUtil.stringify(employ)));
    }
}
