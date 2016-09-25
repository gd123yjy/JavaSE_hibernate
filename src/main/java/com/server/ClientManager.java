package com.server;

import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by yjy on 16-9-24.
 */
public class ClientManager {

    private ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<Runnable>(5));

    public ClientManager(){
        System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" +
                executor.getQueue().size() + "，已执行完别的任务数目：" + executor.getCompletedTaskCount());
    }

    public void server(Socket socket) {
        MyTask myTask = new MyTask(socket);
        System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" +
                executor.getQueue().size() + "，已执行完别的任务数目：" + executor.getCompletedTaskCount());
        System.out.println("开始新任务```");
        executor.execute(myTask);
    }
}
