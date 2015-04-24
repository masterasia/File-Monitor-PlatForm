package com.xt.fmf.monitor;

import com.xt.fmf.executor.Executor;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2015/4/24.
 */
public class Monitor extends Thread {
    private Set<Executor> executors = new HashSet<Executor>();

    @Override
    public void run() {
        while(true){
            for (Executor executor:executors){
                if (executor.isAlive())
                    continue;

                Executor nExecutor = new Executor(executor.getPath());
                nExecutor.start();
                executors.remove(executor);
                executors.add(nExecutor);
            }

            try{
                sleep(30*1000);
            } catch (InterruptedException e) {

            }
        }
    }

    public Set<Executor> getExecutors() {
        return executors;
    }

    public void setExecutors(Set<Executor> executors) {
        this.executors = executors;
    }

    public void addExecutor(Executor executor) {
        executors.add(executor);
    }

    public void rmExecutor(Executor executor) {
        executors.remove(executor);
    }
}
