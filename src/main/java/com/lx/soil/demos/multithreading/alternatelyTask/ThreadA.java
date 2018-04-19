package com.lx.soil.demos.multithreading.alternatelyTask;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : Aslan
 * @version : v1.0
 * @time : 2018-04-19 10:16
 * @desc :
 */
public class ThreadA implements Runnable{
    private TaskService taskService;
    public  ThreadA(TaskService taskService){
       this.taskService =taskService;
    }

    @Override
    public void run() {
        for(int i =0;i<50;i++){
            taskService.taskA();
        }
    }
}
