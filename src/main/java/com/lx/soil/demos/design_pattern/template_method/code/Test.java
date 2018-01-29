package com.lx.soil.demos.design_pattern.template_method.code;

/**
 * @author : Aslan
 * @version : v1.0
 * @time : 2018-01-23 10:00
 * @desc : 输入描述
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("开始泡饮料");
        Tea t = new Tea();
        t.beverageTemplate();
        System.out.println("==============================================");
        Coffee c = new Coffee();
        c.beverageTemplate();

        System.out.println("结束泡饮料");
    }
}
