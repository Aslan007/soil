package com.lx.soil.demos.design_pattern.observer.code;

/**
 * @author : Aslan
 * @version : v1.0
 * @time : 2018-01-23 14:16
 * @desc :具体目标对象，负责把有关状态存入相应的观察者对象中
 */
public class ConcreteSubject extends Subject {

    //目标的状态
    private String subjectState;

    public String getSubjectState() {
        return subjectState;
    }
    //在目标修改时，通知观察者
    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
        this.notifyObservers();
    }

}
