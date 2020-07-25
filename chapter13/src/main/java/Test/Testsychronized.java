package Test;

public class Testsychronized {
    public static void main(String[] args) {
        final TicketPool ticketPool = new TicketPool();
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

class TicketPool{
    private int ticketNum=30;
    public synchronized void sellTicket(){
        if(ticketNum>0){
            System.out.println("线程"+Thread.currentThread().getName()+"销售第"+ticketNum+"张");
            ticketNum = ticketNum-1;
            System.out.println("线程"+Thread.currentThread().getName()+"销售之后还剩"+ticketNum+"张");
        }else{
            System.out.println("线程"+Thread.currentThread().getName()+"销售没拿到票");
        }

    }

}
