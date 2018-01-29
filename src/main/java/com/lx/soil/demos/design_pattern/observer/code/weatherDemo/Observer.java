package com.lx.soil.demos.design_pattern.observer.code.weatherDemo;

import com.lx.soil.demos.design_pattern.observer.code.Subject;

/**
 * @author : Aslan
 * @version : v1.0
 * @time : 2018-01-23 14:15
 * @desc : 输入描述
 */
public interface Observer {

    public void update(WeatherSubject  s);
}
