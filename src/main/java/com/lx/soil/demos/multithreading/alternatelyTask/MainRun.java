package com.lx.soil.demos.multithreading.alternatelyTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : Aslan
 * @version : v1.0
 * @time : 2018-04-19 10:20
 * @desc : 线程间通信demo：入口类，两个线程交替运行打印奇数和偶数
 */
public class MainRun {

    public static void main(String[] args) {

        TaskService taskService =new TaskService();
        ThreadA threadA =new ThreadA(taskService);
        ThreadB threadB = new ThreadB(taskService);
        ExecutorService cachedThreadPool    = Executors.newCachedThreadPool();

        cachedThreadPool.execute(threadA);
        cachedThreadPool.execute(threadB);


    }



}
