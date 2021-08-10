package com.eshare;

/**
 * @Author Evan Leung
 **/
public class InterruptDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyThread());
        t1.start();

        Thread.sleep(5000);
        t1.interrupt();
        Thread.interrupted();
    }




}

class MyThread implements Runnable{


    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            System.out.println(Thread.currentThread().getName()+"在处理文件...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(Thread.currentThread().getName()+"线程被终端，更新文件处理状态");
                //中断线程，结束执行
                Thread.currentThread().interrupt();
                System.out.println("中断当前线程："+Thread.currentThread().getName());
            }

        }
    }
}