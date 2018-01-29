package com.lx.soil.demos.design_pattern.observer.code.weatherDemo;

/**
 * @author : Aslan
 * @version : v1.0
 * @time : 2018-01-23 14:16
 * @desc :具体目标对象，负责把有关状态存入相应的观察者对象中
 */
public class WeatherConcreteSubject extends WeatherSubject {

    //目标的状态
    private String weatherContent;

    public String getWeatherContent() {
        return weatherContent;
    }

    public void setWeatherContent(String weatherContent) {
        this.weatherContent = weatherContent;
        this.notifyObservers();
    }
}
