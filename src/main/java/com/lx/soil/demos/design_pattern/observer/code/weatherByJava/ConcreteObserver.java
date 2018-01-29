package com.lx.soil.demos.design_pattern.observer.code.weatherByJava;

import java.util.Observable;
import java.util.Observer;

/**
 * @author : Aslan
 * @version : v1.0
 * @time : 2018-01-23 16:29
 * @desc : 输入描述
 */
//具体的观察者对象
public class ConcreteObserver implements Observer{
    private String observerName;

    public String getObserverName() {
        return observerName;
    }
    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }


    @Override
    public void update(Observable o, Object arg) {
    //推的方式
        System.out.println(observerName+" 收到了推来的消息 内容是 "+arg);
    //拉的方式
        System.out.println(observerName+" 收到了拉来的消息 内容是 "
                +((ConcreteWeatherSubject)o).getContent());
    }
}
