package com.lx.soil.demos.design_pattern.observer.code.weatherDemo;


import java.util.ArrayList;
import java.util.List;

/**
 * @author : Aslan
 * @version : v1.0
 * @time : 2018-01-23 14:15
 * @desc : 目标类，他知道他的观察者，并提供注册和删除观察者的接口，以及通知的方法
 */
public class WeatherSubject {

    //保存注册的观察者
     private List<Observer> observers = new ArrayList<Observer>();

    /**
     * 往集合中添加观察者
     * @param o
     */
     public void attach(Observer o){
         observers.add(o);
     }

    /**
     * 删除集合中指定观察者
     * @param o
     */
    public void detach(Observer o){
        observers.remove(o);
    }

    /**
     * 通知所有已经订阅了天气的人
     */
    protected void notifyObservers(){
        for(Observer o:observers){
           o.update(this);
        }
    }

}
