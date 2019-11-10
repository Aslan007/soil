package com.lx.soil.demos.design_pattern.reschain.chain;

import com.lx.soil.demos.design_pattern.reschain.LeaveRequest;
import com.lx.soil.demos.design_pattern.reschain.chain.AbstractChain;

/**
 * @program: soil
 * @description: 主管处理环节
 * @author: Aslan
 * @create: 2019-11-10 17:51
 * @version: V0.1
 **/
public class DirectorChain extends AbstractChain {

    public DirectorChain(String name) {
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
        String log = "主管<%s>审批<%s>请假<%s>天的申请，审批结果:<%s>";
        System.out.println(String.format(log, this.name, request.getName(), request.getDays(), result == true ? "批准" : "驳回"));
        if (!result) {
            return false;
        } else if (request.getDays() < 3) {
            return true;
        }
        return nextChain.process(request);
    }
}