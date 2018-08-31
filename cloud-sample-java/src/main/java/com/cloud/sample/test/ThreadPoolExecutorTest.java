package com.cloud.sample.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolExecutorTest {

    public static void main(String[] args) throws Exception{
        new Thread(()->{
            try{
                exec();
            }catch (Exception e){

            }

        }).start();
        System.out.println("hahahahah");
    }




    static class Task implements Callable<String> {
        private int a;

        public Task(int a){
            this.a = a;
        }
        @Override
        public String call() throws Exception {
            System.out.println("Test Invoke All");
            Thread.sleep(5000);
            return "hello callable"+" "+a+" "+Thread.currentThread().getName();
        }
    }


    public static void exec() throws Exception{
        List<Task> tasks = new ArrayList<>();
        for(int i=0;i<10;i++){
            Task task = new Task(i);
            tasks.add(task);
        }
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,10,60L,TimeUnit.SECONDS,new LinkedBlockingQueue<>());

        try {
            List<Future<String>> futures = threadPoolExecutor.invokeAll(tasks);
            for (Future future:futures){
                System.out.println(future.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            threadPoolExecutor.shutdown();
        }

    }
}

