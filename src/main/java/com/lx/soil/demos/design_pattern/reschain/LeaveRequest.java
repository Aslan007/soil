package com.lx.soil.demos.design_pattern.reschain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @program: soil
 * @description: 请假申请
 * @author: Aslan
 * @create: 2019-11-10 17:50
 * @version: V0.1
 **/
@Getter
@Setter
public class LeaveRequest {
    public String name;
    public Integer days;

    public LeaveRequest(String name, Integer days) {
        this.name = name;
        this.days = days;
    }
}