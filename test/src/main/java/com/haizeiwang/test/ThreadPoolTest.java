package com.haizeiwang.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    public static void main(String[] args) {
        /** newCachedThreadPool可缓存线程池，可回收空闲线程，若无空闲线程，则会新建线程
         * ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
         *         for (int i = 0; i < 10; i++) {
         *             final int index = i;
         *             try {
         *                 Thread.sleep(index * 1000);
         *             } catch (InterruptedException e) {
         *                 e.printStackTrace();
         *             }
         *             cachedThreadPool.execute(new Runnable() {
         *                 public void run() {
         *                     System.out.println(index);
         *                     System.out.println(Thread.currentThread().getName());
         *                 }
         *             });
         *         }
         */


        /** newFixedThreadPool设置一个定长的线程池，
         * ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
         *         for (int i = 0; i < 10; i++){
         *             final int index = i;
         *
         *             fixedThreadPool.execute(new Runnable() {
         *                 public void run() {
         *                     try {
         *                         System.out.println(index);
         *                         System.out.println(Thread.currentThread().getName());
         *                         Thread.sleep(2000);
         *                     } catch (InterruptedException e) {
         *                         e.printStackTrace();
         *                     }
         *                 }
         *             });
         *         }
         */

        /**newScheduledThreadPool 定长可设置延迟周期执行任务的线程池
         *  ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
         * //        scheduledThreadPool.schedule(new Runnable() {
         * //            public void run() {
         * //                System.out.println(Thread.currentThread().getName());
         * //                System.out.println("delay 3 seconds");
         * //            }
         * //        },3, TimeUnit.SECONDS);
         *         scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
         *             public void run() {
         *                 System.out.println(Thread.currentThread().getName());
         *                 System.out.println("delay 3 seconds");
         *             }
         *         },1, 3, TimeUnit.SECONDS);
         */

        /**newSingleThreadExecutor 单线程化线程池，只会用唯一的线程来按照指定顺序执行任务
         * ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
         *         for (int i = 0; i < 10; i++) {
         *             final int index = i;
         *             singleThreadExecutor.execute(new Runnable() {
         *                 public void run() {
         *                     try {
         *                         System.out.println(Thread.currentThread().getName());
         *                         System.out.println(index);
         *                         Thread.sleep(2000);
         *                     } catch (InterruptedException e) {
         *                         e.printStackTrace();
         *                     }
         *                 }
         *             });
         *         }
         */


    }

}
