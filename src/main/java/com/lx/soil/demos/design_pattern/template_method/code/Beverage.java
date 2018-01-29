package com.lx.soil.demos.design_pattern.template_method.code;

/**
 * @author : Aslan
 * @version : v1.0
 * @time : 2018-01-23 9:34
 * @desc : 抽象基类，用于定义模板方法，方法用定义成final，不能被子类覆写
 * 遵循好莱坞原则
 */

public abstract class Beverage {

    public final void beverageTemplate(){
        //烧水
        boilwater();
        //冲泡
        brew();
        //倒入杯子
        pourIncup();
        //加点调料
        if(isNeedSugar()){
            addSugar();
        }
    }

    protected  void boilwater(){
        System.out.println("烧水");
    }

    protected abstract void brew();

    private void pourIncup() {
        System.out.println("倒进杯子");
    }

    protected abstract void addSugar();

    //hook方法 钩子函数 提供一个默认或者空的实现，具体实现给用户选择，可以让子类根据需求覆写
    protected boolean isNeedSugar(){
        return true;
    }





}
