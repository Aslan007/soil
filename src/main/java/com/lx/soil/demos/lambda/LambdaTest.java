package com.lx.soil.demos.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Aslan
 * @version : v1.0
 * @time : 2018-02-09 16:42
 * @desc : java8, Lambda表达式使用
 */
public class LambdaTest {
    //https://www.cnblogs.com/franson-2016/p/5593080.html
    //http://blog.csdn.net/bitcarmanlee/article/details/70195403

    public static void main(String[] args) {
        //-------------------------- 1.使用lambda进行迭代 ----------------------------------------------------------
        List<String> languages = Arrays.asList("java","scala","python");
        //before java8
        for(String each:languages) {
            System.out.println(each);
        }
        //after java8
        languages.forEach(x -> System.out.println(x));
        languages.forEach(System.out::println);
        //------------------------------2.使用lambda表达式使用匿名内部类，经典使用是多线程--------------------------------

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("The old runable now is using!");
            }
        }).start();

        //after java8
        new Thread(() -> System.out.println("It's a lambda function!")).start();

        //-------------------------------------------------------------------------
        // 3. 用lambda表达式实现map
        List<Double> cost = Arrays.asList(10.0, 20.0,30.0);
        cost.stream().map(x -> x + x*0.05).forEach(x -> System.out.println(x));

        //---------------------------------------------------------------------------
        //4. 用lambda表达式实现map与reduce【做了一个求和的操作】
       //before java8
        List<Double> cost2 = Arrays.asList(10.0, 20.0,30.0);
        double sum = 0;
        for(double each:cost2) {
            each += each * 0.05;
            sum += each;
        }
        System.out.println(sum);

        //after java8
        List<Double> cost1 = Arrays.asList(10.0, 20.0,30.0);
        double allCost = cost1.stream().map(x -> x+x*0.05).reduce((sum1,x) -> sum1 + x).get();
        System.out.println(allCost);
        //----------------------------------------------------------------------------------
        //5. filter操作，过滤，只显示大于25的值
        List<Double> filteredCost = cost.stream().filter(x -> x > 25.0).collect(Collectors.toList());
        filteredCost.forEach(x -> System.out.println(x));

        //----------------------------------------------------------------------------------
        //6.
    }
}
