package com.javathread;

import java.util.*;
import java.util.concurrent.*;

/**
 * @description:线程池Thread Pool
 * @author: dt
 * @date: 2021/7/25 10:20
 */
public class demo4 implements Callable<String[]> {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建有2个线程的线程池
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        //提交执行字符串切割任务
        Future<String[]> future=executorService.submit(new demo4("a b b c "));
        String s = Arrays.toString(future.get());
        System.out.println(s);

        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("线程定时任务");
            }
        },new Date(),3000);

//        关闭
        executorService.shutdown();


    }
    private String string;

    public demo4(String string) {
        this.string = string;
    }

    @Override
    public String[] call() throws Exception {
        return string.split(" +");
    }
}
class ConcurrentHashMapTest {
    public static void main(String[] args) {
//        ConcurrentHashMap集合特点
        /**
          - 底层是哈希表结构
          - 此集合是线程安全的，但是某些功能不必锁定。比如get()
          - 不会抛出ConcurrentModificationException并发修改异常
            - 此集合支持遍历过程中添加，删除元素。

          - ConcurrentHashMap集合的锁定特点
          - 为了提高效率，不会将整个集合全部锁定。
          - 当添加或者移除元素时，是对链表进行操作，链表存储在数组中，那么就只会针对这个链表进行锁定。
        * */

//        Map<String,String> map = new ConcurrentHashMap<String,String>();
//        map.put("1","a");
//        map.put("2","b");
//        map.put("3","c");
//        System.out.println(map);
//
//        Set<Map.Entry<String,String>> set = map.entrySet();
//        Iterator<Map.Entry<String,String>> it = set.iterator();
//        while (it.hasNext()){
//            map.put("4","4");
//            Map.Entry<String, String> next = it.next();
//            System.out.println(next.getKey()+"="+next.getValue());
//        }

        Map<String,String> map=new ConcurrentHashMap<>();
//        Map<String,Integer> map = new HashMap<>();
        //存储2000个键值对
        for(int x = 0 ; x < 2000; x++){
            map.put("count"+x,"1");
        }
        //开启线程，删除前500个
        Runnable r1 = () -> {
            for(int i = 0 ; i < 500;i++){
                map.remove("count"+i);
            }
        };
        //开启线程，删除1000-1500个
        Runnable r2 = () -> {
            for(int i = 1000 ; i < 1500;i++){
                map.remove("count"+i);
            }
        };
        new Thread(r1).start();
        new Thread(r2).start();
        //等待2秒，让2个线程全部运行完毕
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印集合长度，线程安全集合应该是1000
        System.out.println(map.size());
    }
}