package com.xt.fmf.executor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by robert xu on 2015/5/14.
 */
public class FileTailer {
    private File file;

    private RandomAccessFile randomAccessFile;

    private long lastIndex;

    public FileTailer(String path) {
        file = new File(path);
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String findNext(long index){
        String next = null;
        try {
            randomAccessFile.seek(index);
            next = randomAccessFile.readLine();
            lastIndex = randomAccessFile.getFilePointer();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return next;
    }

    public long getLastIndex() {
        return lastIndex;
    }

    public void setLastIndex(long lastIndex) {
        this.lastIndex = lastIndex;
    }
}
