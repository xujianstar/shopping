package com.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import org.apache.zookeeper.Watcher.Event.KeeperState ;
import org.apache.zookeeper.Watcher.Event.EventType ;
public class ZookeeperDemo {
    private static final String CONNECT_ADDR ="112.74.82.64:2181";
    private static final CountDownLatch countDownLatch = new CountDownLatch(2);
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        System.out.println("zk操作开始");
        ZooKeeper zk = new ZooKeeper(CONNECT_ADDR, 3000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("zk  watchedEvent111");
                KeeperState state =watchedEvent.getState();
                EventType eventType = watchedEvent.getType();
                System.out.println("zk  watchedEvent");
                if (Event.KeeperState.SyncConnected ==  state) {
                    if(Event.EventType.None == eventType){
                        System.out.println("zk 建立连接失败");
                    }else if(EventType.NodeCreated == eventType){
                        countDownLatch.countDown();
                        System.out.println("简单被创建");
                    }
                }
            }
        });
        countDownLatch.await();
        String result =zk.create("/xujian23", "尼玛OK".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT );
        System.out.println("创建子节点成功, result = "+result);
        zk.close();
    }
}
