package com.lx.soil.demos.design_pattern.reschain.chain;

import com.lx.soil.demos.design_pattern.reschain.LeaveRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * @program: soil
 * @description: 处理者抽象类
 * @author: Aslan
 * @create: 2019-11-10 17:40
 * @version: V0.1
 **/
@Setter
@Getter
public abstract class AbstractChain {
    protected String name;
    protected AbstractChain nextChain;

    public AbstractChain(String name) {
        this.name = name;
    }

    /**
     * 处理方法
     * @return
     */
    public abstract boolean process(LeaveRequest request);

}