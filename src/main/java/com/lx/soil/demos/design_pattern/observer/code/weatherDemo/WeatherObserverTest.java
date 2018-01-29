package com.lx.soil.demos.design_pattern.observer.code.weatherDemo;

/**
 * @author : Aslan
 * @version : v1.0
 * @time : 2018-01-23 15:10
 * @desc : 测试类
 */
public class WeatherObserverTest {

    public static void main(String[] args) {
        //创建目标
        WeatherConcreteSubject subject = new WeatherConcreteSubject();
        //创建观察者
        ConcreteObserver observerGirl = new ConcreteObserver();
        observerGirl.setObserverName("订阅者1号-少女");
        observerGirl.setRemindThings("提醒上课");
        ConcreteObserver observerMom = new ConcreteObserver();
        observerMom.setObserverName("订阅者2号-母亲");
        observerMom.setRemindThings("提醒购物");
        //注册观察者
        subject.attach(observerGirl);
        subject.attach(observerMom);
        //发布天气
        subject.setWeatherContent("天气晴好！");
    }


}
