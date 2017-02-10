package com.blog.common.httpclient;

import org.apache.http.conn.HttpClientConnectionManager;

/**
 * Created by liuhb on 2017/1/12.
 */
public class IdleConnectionEvictor extends Thread{

    private final HttpClientConnectionManager connMgr;

    private volatile boolean shutdown;

    public IdleConnectionEvictor(HttpClientConnectionManager connMgr){
        this.connMgr = connMgr;
        this.start();
    }

    @Override
    public void run() {
        try {
            while (!shutdown){
                synchronized (this){
                    wait(5000);
                    connMgr.closeExpiredConnections();
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void shutdown(){
        shutdown = true;
        synchronized (this){
            notify();
        }
    }
}
