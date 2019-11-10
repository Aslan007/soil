package com.lx.soil.demos.design_pattern.reschain.chain;

import com.lx.soil.demos.design_pattern.reschain.LeaveRequest;

/**
 * @program: soil
 * @description: 总经理审批环节
 * @author: Aslan
 * @create: 2019-11-10 18:18
 * @version: V0.1
 **/
public class TopManagerChain extends AbstractChain{
    public TopManagerChain(String name) {
        super(name);
    }

    /**
     * 处理方法
     *
     * @param request
     * @return
     */
    @Override
    public boolean process(LeaveRequest request) {
        Boolean result = Math.random() * 10 > 5 ? true : false;
        String log = "总经理<%s>审批<%s>请假<%s>天的申请，审批结果:<%s>";
        System.out.println(String.format(log, this.name, request.getName(), request.getDays(), result == true ? "批准" : "驳回"));
        if (!result) {
            return false;
        }
        return true;
    }
}