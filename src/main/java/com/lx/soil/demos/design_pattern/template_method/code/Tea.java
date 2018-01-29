package com.lx.soil.demos.design_pattern.template_method.code;

/**
 * @author : Aslan
 * @version : v1.0
 * @time : 2018-01-23 9:57
 * @desc : 输入描述
 */
public class Tea extends Beverage{

    @Override
    protected void brew() {
        System.out.println("泡茶");
    }

    @Override
    protected void addSugar() {
        System.out.println("加入柠檬");
    }

    /**
     * 覆写钩子函数，选择不加调料，会让上面的addsugar()失效
     * @return
     */
    @Override
    protected boolean isNeedSugar() {
        return false;
    }
}
