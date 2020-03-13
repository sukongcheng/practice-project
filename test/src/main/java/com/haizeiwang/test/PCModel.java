package com.haizeiwang.test;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class PCModel {
    private static LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();

    public static void main(String[] args) {
        Thread provider = new Thread(() -> {
            Random random = new Random();
            for (int i = 0; i < 5; i++){
                try {
                    Integer n = random.nextInt();
                    queue.put(n);
                    System.out.println("生产数据:" + n);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            Integer n;
            for (int i = 0; i < 5; i++){
                try {
                    n = queue.take();
                    System.out.println("消费数据:" + n);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        provider.start();
        consumer.start();

    }
}
