package com.lx.soil.demos.design_pattern.reschain;

import com.lx.soil.demos.design_pattern.reschain.chain.AbstractChain;
import com.lx.soil.demos.design_pattern.reschain.chain.DirectorChain;
import com.lx.soil.demos.design_pattern.reschain.chain.ManagerChain;
import com.lx.soil.demos.design_pattern.reschain.chain.TopManagerChain;

/**
 * @program: soil
 * @description: 测试调用入口类
 * @author: Aslan
 * @create: 2019-11-10 17:42
 * @version: V0.1
 **/
public class Main {
    //使用责任链的目标：1.可以灵活定义每一个环节的先后顺序，2.每个环节可单独调用，互不影响
    //以请假为例，3人审批，director，manager，topManager


    /**
     *
     * 问题：
     * 1.需要使用链条的起始节点调用，不够灵活，查看时也不够方便
     * 2.设置下一节点的工作太繁琐
     * @param args
     */
    public static void main(String[] args) {
        //设置链条顺序
        AbstractChain director = new DirectorChain("jack");
        AbstractChain manager = new ManagerChain("mark");
        AbstractChain topManager = new TopManagerChain("eric");

        director.setNextChain(manager);
        manager.setNextChain(topManager);

        Boolean result = director.process(new LeaveRequest("Lucy",1));
        System.out.println("最终结果：" + result);
        Boolean result2 = director.process(new LeaveRequest("claire",7));
        System.out.println("最终结果：" + result2);
        Boolean result3 = director.process(new LeaveRequest("summer",3));
        System.out.println("最终结果：" + result3);

    }
}