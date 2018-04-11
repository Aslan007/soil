package com.lx.soil.demos.multithreading;

import java.util.concurrent.*;

/**
 * @author : Aslan
 * @version : v1.0
 * @time : 2018-04-10 10:14
 * @desc : 使用Executors创建4种不同的线程池
 */
public class CreateThreadPool {

    public static void main(String[] args) {

        /**
         * 四种线程池创建，使用Executors自动创建，可能会有问题
         * newCachedThreadPool()，newScheduledThreadPool(5)
         * 这两种创建线程的数量是 Integer.MAX_VALUE,可能创建很多线程，导致OOM【out of memory】
         * newFixedThreadPool(),newSingleThreadExecutor()
         * 这两种方式堆积的请求处理队列可能会消耗非常大的内存，甚至OOM
         *
         * 在线程池满了之后，后进来的任务，会在队列中等待，如果队列也满了，则会进入到饱和策略处理
         */

        /**
         *  newCachedThreadPool()
         *  (一)创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
         *  这里的线程池是无限大的，当一个线程完成任务之后，这个线程可以接下来完成将要分配的任务，而不是创建一个新的线程。
         *
         */

        ExecutorService cachedThreadPool    = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //传统的写法
           /* cachedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println(index);
                }
            });*/
            //lamda8表达式启动
            cachedThreadPool.execute(() -> System.out.println(index));
        }

        /**
         *
         * newFixedThreadPool()
         * (二)创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
         * 定长线程池的大小最好根据系统资源进行设置。
         * 如Runtime.getRuntime().availableProcessors()
         *
         */
       // ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);


        /**
         *  newScheduledThreadPool()
         *  (三)创建一个定长线程池，支持定时及周期性任务执行。
         */
       // ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

        /**
         *
         * newSingleThreadExecutor()
         * (四)按顺序来执行线程任务
         * 但是不同于单线程，这个线程池只是只能存在一个线程，这个线程死后另外一个线程会补上
         */
       // ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();



    }

}
