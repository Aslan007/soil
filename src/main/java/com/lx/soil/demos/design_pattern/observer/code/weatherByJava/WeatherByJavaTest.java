package com.lx.soil.demos.design_pattern.observer.code.weatherByJava;

/**
 * @author : Aslan
 * @version : v1.0
 * @time : 2018-01-23 16:55
 * @desc : 测试类
 */

public class WeatherByJavaTest {

    public static void main(String[] args) {
        //新建观察者
        ConcreteObserver observer = new ConcreteObserver();
        observer.setObserverName("上班族");
        ConcreteObserver observer1 = new ConcreteObserver();
        observer1.setObserverName("上课族");
        //新建发布者
        ConcreteWeatherSubject subject =new ConcreteWeatherSubject();
        //注册观察者
        subject.addObserver(observer);
        subject.addObserver(observer1);
        //发布【修改】消息
        subject.setContent("今日晴天，万里无云");

    }
}
