package com.lx.soil.demos.design_pattern.observer.code.weatherDemo;

import com.lx.soil.demos.design_pattern.observer.code.ConcreteSubject;
import com.lx.soil.demos.design_pattern.observer.code.Subject;

/**
 * @author : Aslan
 * @version : v1.0
 * @time : 2018-01-23 14:16
 * @desc : 订阅者具体实现类
 */
public class ConcreteObserver implements Observer {

    //不同订阅者的名字，不同的订阅者同样的天气，不同的提醒事项
    private String observerName;

    private String weatherContent;

    private String remindThings;


    public String getObserverName() {
        return observerName;
    }

    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }

    public String getWeatherContent() {
        return weatherContent;
    }

    public void setWeatherContent(String weatherContent) {
        this.weatherContent = weatherContent;
    }

    public String getRemindThings() {
        return remindThings;
    }

    public void setRemindThings(String remindThings) {
        this.remindThings = remindThings;
    }

    /**
     * 获取目标类的状态同步到观察者状态中
     * @param s
     */
    @Override
    public void update(WeatherSubject s) {
        weatherContent = ((WeatherConcreteSubject)s).getWeatherContent();
        System.out.println(observerName+" 收到的天气情况是, "+weatherContent+" ,提醒事项是 "+remindThings);
    }
}
