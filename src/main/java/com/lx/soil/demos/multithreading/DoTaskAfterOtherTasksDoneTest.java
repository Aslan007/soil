package com.lx.soil.demos.multithreading;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author : Aslan
 * @version : v1.0
 * @time : 2018-04-11 9:54
 * @desc : demo：实现获取多个任务的返回结果，根据这些任务的返回结果，来打印不同的check信息
 *          参考：https://blog.csdn.net/xyqintj/article/details/68948903
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
         *
         * 获取任务执行的返回值，并将返回值存到rest布尔数组
         *
         * 使用submit 方法来提交任务，它会返回一个future,可以通过这个future来判断任务是否执行成功，
         * 通过future的get方法来获取返回值，get方法会阻塞住直到任务完成，
         * 而使用get(long timeout, TimeUnit unit)方法则会阻塞一段时间后立即返回，这时有可能任务没有执行完。
         *
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
         *
         * 可以通过调用线程池的shutdown或shutdownNow方法来关闭线程池，
         * 原理是遍历线程池中的工作线程，然后逐个调用线程的interrupt方法来中断线程，所以无法响应中断的任务可能永远无法终止。
         * 两者的区别是：shutdownNow首先将线程池的状态设置成STOP，然后尝试停止所有的正在执行或暂停任务的线程，并返回等待执行任务的列表，
         * 而shutdown只是将线程池的状态设置成SHUTDOWN状态，然后中断所有没有正在执行任务的线程。
         * 只要调用了这两个关闭方法的其中一个，isShutdown方法就会返回true。
         * 当所有的任务都已关闭后,才表示线程池关闭成功，这时调用isTerminaed方法会返回true。
         * 至于我们应该调用哪一种方法来关闭线程池，应该由提交到线程池的任务特性决定，
         * 【通常调用shutdown来关闭线程池，如果任务不一定要执行完，则可以调用shutdownNow。】
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
