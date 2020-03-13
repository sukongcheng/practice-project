package com.haizeiwang.test;

public class ThreadTest {

    public static class MyThread implements Runnable{
        private char z;

        public MyThread(char z){
            this.z = z;
        }

        public void run() {
            System.out.println(z);
        }
    }

    public static void main(String[] args) {
        MyThread thread1 = new MyThread('A');
        MyThread thread2 = new MyThread('B');
        MyThread thread3 = new MyThread('C');

        for (int i = 0; i < 3; i++){

            try {
                new Thread(thread1).start();
                Thread.sleep(100);
                new Thread(thread2).start();
                Thread.sleep(100);
                new Thread(thread3).start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}
