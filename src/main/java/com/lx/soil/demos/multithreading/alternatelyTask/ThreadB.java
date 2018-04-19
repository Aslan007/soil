package com.lx.soil.demos.multithreading.alternatelyTask;

/**
 * @author : Aslan
 * @version : v1.0
 * @time : 2018-04-19 10:18
 * @desc : 输入描述
 */
public class ThreadB implements Runnable{
    private TaskService taskService;

    public ThreadB(TaskService taskService){
        this.taskService =taskService;
    }

    @Override
    public void run() {
        for(int i =0;i<50;i++) {
            taskService.taskB();
        }
    }
}
