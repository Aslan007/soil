package com.lx.soil.demos.design_pattern.template_method.code;

/**
 * @author : Aslan
 * @version : v1.0
 * @time : 2018-01-23 10:02
 * @desc : 输入描述
 */
public class Coffee extends Beverage {

    @Override
    protected void brew() {
        System.out.println("泡咖啡");
    }

    @Override
    protected void addSugar() {
        System.out.println("加入牛奶和糖");
    }
}
