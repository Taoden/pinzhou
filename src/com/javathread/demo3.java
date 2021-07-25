package com.javathread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:Lock锁
 * @author: dt
 * @date: 2021/7/25 9:24
 */
public class demo3 implements Runnable{
    private int ticket = 100;
    //Lock接口实现类
//    接口实现类：`java.util.locks.lock.ReentrantLock`
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        demo3 demo3=new demo3();
        Thread thread1=new Thread(demo3,"一");
        Thread thread2=new Thread(demo3,"二");
        Thread thread3=new Thread(demo3,"三");
        thread1.start();
        thread2.start();
        thread3.start();
    }

    @Override
    public void run() {
        //每个窗口卖票的操作
        //窗口 永远开启
        while(true){
            lock.lock();
            if(ticket>0) {//有票 可以卖
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //获取当前线程对象的名字
                String name = Thread.currentThread().getName();
                System.out.println(name+"正在卖:"+ticket--);
            }
           lock.unlock();
            }
    }
}

class BaoziPu{
    /**
    * 定义一个变量，包子铺线程完成生产包子，包子进行++操作；吃货线程完成购买包子，包子变量打印出来。
    1. 当包子没有时（包子状态为false），吃货线程等待。
    2. 包子铺线程生产包子（即包子状态为true），并通知吃货线程（解除吃货的等待状态）。
    3. 保证线程安全，必须生产一个消费一个，不能同时生产或者消费多个。
    * */

    public static void main(String[] args) {
        BaoziPu baoziPu=new BaoziPu();
        Product product=new Product(baoziPu);
        Customer customer=new Customer(baoziPu);
//        Thread thread=new Thread(product);
//        thread.start();
        new Thread(product).start();
        new Thread(customer).start();


//      sleep()是Thread类静态方法，不需要对象锁。
//-     wait()方法是Object类的方法，被锁对象调用，而且只能出现在同步中。
//-     执行sleep()方法的线程不会释放同步锁。
//-     执行wait()方法的线程要释放同步锁，被唤醒后还需获取锁才能执行。
    }

    private int baoZiCount;
    //标志位变量
    //当包子没有时（包子状态为false），吃货线程等待。
    //包子铺线程生产包子（即包子状态为true），并通知吃货线程（解除吃货的等待状态）。
    private boolean flag;

    //创建Lock接口实现类，线程安全提供锁定
    private Lock lock=new ReentrantLock();
    //Condition对象和生产者锁结合
    private Condition productCondition=lock.newCondition();
    //Condition对象和消费者锁结合
    private Condition customerCondition = lock.newCondition();

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    //消费者调用方法，变量输出
//    public synchronized void get(){
    public  void get(){
        //判断标志位 ==false，没有生产，线程等待
        lock.lock();
        if (flag == false){
            try {
//                this.wait();
           customerCondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }else {
            System.out.println("消费第"+baoZiCount+"个包子");
            //修改标志位
            flag = false;
            //唤醒对方线程
//            this.notifyAll();
//            消费完唤醒生产者
            productCondition.signal();
            lock.unlock();
        }

    }
    //生产者调用方法，变量++
//    public synchronized void set(){
    public  void set(){
        lock.lock();
        //判断标志位，==true，没有消费，线程等待
        if(flag == true){
            try {
//                this.wait();
                productCondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }else {
            baoZiCount++;
            System.out.println("生产第"+baoZiCount+"个包子");
            //修改标志位
            flag = true;
            //唤醒对方线程
//            this.notifyAll();
//                      生成完唤醒消费者
            customerCondition.signal();
            lock.unlock();
        }

    }
}
class Product implements Runnable{
    private BaoziPu baoZiPu;

    public Product(BaoziPu baoZiPu) {
        this.baoZiPu = baoZiPu;
    }

    @Override
    public void run() {
        while (true) {
            baoZiPu.set();
        }
////生产者线程判断标志位变量，==true，已经生产还没有消费
//            synchronized (baoZiPu) {
//                if (baoZiPu.getFlag() == true) {
//                    try {
//                        baoZiPu.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                //生产一个
//                baoZiPu.set();
//                //修改标志位
//                baoZiPu.setFlag(true);
////            唤醒对方线程
//                baoZiPu.notify();
//            }
//        }
    }
}
class Customer implements Runnable {
    private BaoziPu baoZiPu;

    public Customer(BaoziPu baoZiPu) {
        this.baoZiPu = baoZiPu;
    }

    @Override
    public void run() {
        while (true){
            baoZiPu.get();
        }

//        while (true){
//            synchronized (baoZiPu) {
//                //消费者线程判断标志位，==false，没有生产
//                if (baoZiPu.getFlag() == false) {
//                    try {
//                        //线程等待
//                        baoZiPu.wait();
//                    } catch (InterruptedException ex) {
//                    }
//                }
//                //调用消费方法
//                baoZiPu.get();
//                //修改标志位
//                baoZiPu.setFlag(false);
//                //唤醒对方线程
//                baoZiPu.notify();
//            }
//        }

    }
}

class CondTest{
//    Lock接口的方法newCondition()获取
//
//- `public Condition newCondition()`
//    | public void await()     | 线程等待，释放锁,进入队列         |
//| public void signal()    | 唤醒一个等待的线程，出队列,获取锁 |
//| public void singalAll() | 唤醒所有等待的线程                |


}