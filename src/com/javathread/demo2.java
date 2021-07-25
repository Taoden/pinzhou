package com.javathread;

/**
 * @description:线程安全问题
 * @author: dt
 * @date: 2021/7/25 9:03
 */
public class demo2 implements Runnable {
    private int ticket = 100;
    private Object lock = new Object();
    public static void main(String[] args) {
        //创建线程任务对象
        demo2 demo = new demo2();
        //创建三个窗口对象
        Thread thread1=new Thread(demo,"窗口1");
        Thread thread2=new Thread(demo,"窗口2");
        Thread thread3=new Thread(demo,"窗口3");
        thread1.start();
        thread2.start();
        thread3.start();

    }

    /*
     * 执行卖票操作
     */
    @Override
    public void run() {
//         //每个窗口卖票的操作
//        //窗口 永远开启
          while (true) {
              /*
               * 锁对象 是 谁调用这个方法 就是谁
               *   隐含 锁对象 就是  this
               *
               */
            synchronized (lock){
                if (ticket > 0) {//有票 可以卖
                    //出票操作
                    //使用sleep模拟一下出票时间
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在卖:" + ticket--);
                }else {
                    break;
                }
            }

        }
    }
}

class DeadLock implements Runnable{
    private boolean flag;
    public DeadLock(boolean flag) {
        this.flag = flag;
    }
    public static void main(String[] args) {
//            Test
        DeadLock deadLock1=new DeadLock(true);
        DeadLock deadLock2=new DeadLock(false);

        Thread thread1=new Thread(deadLock1);
        Thread thread2=new Thread(deadLock2);
        thread1.start();
        thread2.start();

//        | NEW(新建)               | 线程刚被创建，但是并未启动。还没调用start方法。
//        | Runnable(可运行)        | 线程可以在java虚拟机中运行的状态，可能正在运行自己代码，也可能没有，这取决于操作系统处理器。 |
//        | Blocked(锁阻塞)         | 当一个线程试图获取一个对象锁，而该对象锁被其他的线程持有，则该线程进入Blocked状态；当该线程持有锁时，该线程将变成Runnable状态。 |
//        | Waiting(无限等待)       | 一个线程在等待另一个线程执行一个（唤醒）动作时，该线程进入Waiting状态。进入这个状态后是不能自动唤醒的，必须等待另一个线程调用notify或者notifyAll方法才能够唤醒。 |
//        | Timed Waiting(计时等待) | 同waiting状态，有几个方法有超时参数，调用他们将进入Timed Waiting状态。这一状态将一直保持到超时期满或者接收到唤醒通知。带有超时参数的常用方法有Thread.sleep 、Object.wait。 |
//        | Teminated(被终止)       | 因为run方法正常退出而死亡，或者因为没有捕获的异常终止了run方法而死亡。 |
    }





    @Override
    public void run() {
        while (true){
            if(flag){
                //线程获取r1对象锁
            synchronized (Lock1.lock1){
                System.out.println("if...获取r1锁");
                synchronized (Lock2.lock2){
                    //线程获取r2对象锁
                    System.out.println("if...获取r2锁");
                }
            }
        }else {

                //线程获取r2对象锁
                synchronized (Lock2.lock2){
                    System.out.println("else...获取r2锁");
                    //线程获取r1锁

                    synchronized (Lock1.lock1){
                        System.out.println("else...获取r1锁");
                    }
                }

            }
        }
    }
}
class Lock1{
public static  Lock1 lock1=new Lock1();
}
class Lock2{
public static  Lock2 lock2=new Lock2();
}
