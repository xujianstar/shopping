package Test;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        final TicketPool_1 ticketPool = new TicketPool_1();
        for(int i=0;i<40;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ticketPool.sellTicket();
                }
            }).start();
        }
    }
}
class TicketPool_1{
    private int ticketNum=30;
    private ReentrantLock lock = new ReentrantLock();
    public void sellTicket(){
        try {
            lock.lock();
            if(ticketNum>0){
                System.out.println("线OK程"+Thread.currentThread().getName()+"销售第"+ticketNum+"张");
                ticketNum = ticketNum-1;
                System.out.println("线OK程"+Thread.currentThread().getName()+"销售之后还剩"+ticketNum+"张");
            }else{
                System.out.println("线OK程"+Thread.currentThread().getName()+"销售没拿到票");
            }
        }finally {
            lock.unlock();
        }

    }

}

