package com.xt.fmf.executor;

/**
 * Created by robert xu on 2015/4/24.
 * one target one executor
 */
public class Executor extends Thread{

    /**
     * executor target
     */
    private String path;

    private long index;

    private FileTailer fileTailer;

    public Executor(String path) {
        this.path = path;
        fileTailer = new FileTailer(path);
        initIndex();
    }

    @Override
    public void run() {
        while (true){
            fileTailer.findNext(index);
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    private void initIndex(){
        index = 0;
        //TODO index data persistence
    }
}
