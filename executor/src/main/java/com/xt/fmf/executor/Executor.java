package com.xt.fmf.executor;

/**
 * Created by Administrator on 2015/4/24.
 * one target one executor
 */
public class Executor extends Thread{

    /**
     * executor target
     */
    private String path;

    public Executor(String path) {
        this.path = path;
    }

    @Override
    public void run() {

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
