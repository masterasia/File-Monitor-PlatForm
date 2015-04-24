package com.xt.fmf.server;

import com.xt.fmf.executor.Executor;
import com.xt.fmf.monitor.Monitor;

/**
 * Created by Administrator on 2015/4/24.
 * start server
 */
public class Server {

    private static String[] targets;

    private static Monitor monitor;

    public static void main(String[] args){
        targets = args;
        init();
        start();
    }

    private static void init(){
        monitor = new Monitor();
    }

    private static void start(){
        for (String target:targets){
            Executor executor = new Executor(target);
            executor.start();
            monitor.addExecutor(executor);
        }

        monitor.start();
    }
}
