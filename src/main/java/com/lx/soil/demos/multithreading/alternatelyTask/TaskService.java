package com.lx.soil.demos.multithreading.alternatelyTask;

import lombok.Data;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : Aslan
 * @version : v1.0
 * @time : 2018-04-19 10:12
 * @desc : 需要被交替执行的任务类
 */
@Data
public class TaskService {

    private ReentrantLock reentrantLock =new ReentrantLock();
    private Condition condition = reentrantLock.newCondition();
    private boolean runFlag =true;
    private volatile Integer num=0;

    public void taskA(){

        try {
            reentrantLock.lock();
            //值得注意的是，此处必须使用while循环
             while(runFlag){
                 condition.await();
             }
             System.out.println("taskA是奇數线程：数字num是："+num);
             runFlag = true;
             num++;
             condition.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }
    }

    public void taskB(){

        try {
            reentrantLock.lock();
            while(!runFlag){
                condition.await();
            }
             System.out.println("taskB是偶数线程，数字num是："+num);
             runFlag = false;
             num++;
             condition.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }
    }

}
