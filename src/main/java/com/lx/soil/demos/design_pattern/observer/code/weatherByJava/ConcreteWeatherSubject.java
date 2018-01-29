package com.lx.soil.demos.design_pattern.observer.code.weatherByJava;

import java.util.Observable;

/**
 * @author : Aslan
 * @version : v1.0
 * @time : 2018-01-23 16:21
 * @desc : 输入描述
 */
//天气目标具体实现类
public class ConcreteWeatherSubject extends Observable{
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        //修改时，通知所有注册的订阅者
        //注意在通知之前，用java的observer模式时，此句必输
        this.setChanged();
        //主动通知，我们先用推的方式
        this.notifyObservers(content);
        //如果是拉的方式，调用无参的方式,无参的会默认将subject对象传过去，推拉二选一
        //this.notifyObservers();
    }

}
