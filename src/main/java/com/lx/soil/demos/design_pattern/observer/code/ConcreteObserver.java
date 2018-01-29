package com.lx.soil.demos.design_pattern.observer.code;

/**
 * @author : Aslan
 * @version : v1.0
 * @time : 2018-01-23 14:16
 * @desc : 输入描述
 */
public class ConcreteObserver implements Observer {

    //观察者的状态
    private String observerState;

    /**
     * 获取目标类的状态同步到观察者状态中
     * @param s
     */
    @Override
    public void update(Subject s) {
        observerState = ((ConcreteSubject)s).getSubjectState();
    }
}
