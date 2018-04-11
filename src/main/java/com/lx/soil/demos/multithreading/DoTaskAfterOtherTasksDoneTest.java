package com.lx.soil.demos.multithreading;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author : Aslan
 * @version : v1.0
 * @time : 2018-04-11 9:54
 * @desc : demo：实现获取多个任务的返回结果，根据这些任务的返回结果，来打印不同的check信息
 */
public class DoTaskAfterOtherTasksDoneTest {
    private static ExecutorService executorService = Executors.newCachedThreadPool();
    public static void main(String[] args) {
        new DoTaskAfterOtherTasksDoneTest().test();
    }

    public void test(){
        Future[] tasks = new Future[5];
        Boolean[] rest = new Boolean[5];
        /**
         * 循环提交任务
         */
        for(int i = 0; i < 5; i++){
            tasks[i] = executorService.submit(new Task());
        }
        /**
         * 获取任务执行的返回值，并将返回值存到rest布尔数组
         */
        for(int i = 0; i < 5; i++){
            try {
                Boolean res = (Boolean) tasks[i].get();
                rest[i] = res;
                System.out.println("task "+ i + " " + res);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        /**
         *  反转返回值，运行结果的返回值若为true，则将flag赋值为false
         */
        boolean flag= true;
        for(int i = 0; i < 5; i++){
            System.out.println("check " + rest[i]);
            if(rest[i] != null && rest[i]){
                flag = false;
            }
        }

        /**
         * 打印运行结果，只要有一个失败则为失败
         */
        if(!flag){
            System.out.println("failure");
        } else {
            System.out.println("success");
        }

        /**
         * 关闭线程池
         */
        executorService.shutdown();
        System.out.println("current task");
    }

    /**
     *  实现了Callable的任务类
     */
    class Task implements Callable<Boolean> {

        @Override
        public Boolean call() throws Exception {
            Thread.sleep(2000);
            System.out.println("当前线程名： "+Thread.currentThread().getName());
            boolean ran = new Random().nextBoolean();
            System.out.println("随机返回的运行结果 ran " + ran);
            return ran;
        }

    }
}
