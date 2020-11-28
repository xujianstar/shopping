package Test;

import com.alibaba.fastjson.JSON;

public class M23_a_PA {


}

abstract interface Dealer{
    public void trusteeTransferPa(String msg);
    public void dealMessage();
}

abstract class Message{
    public String bankName="";
    public String bankno ="";
    public String msg ="";
    public abstract void dealMessage();
}

class CCB1241Message extends Message{
    @Override
    public void dealMessage(){
        System.out.println("CCB1241Message deal");
    }

}

class CCB1081Message extends Message{
    @Override
    public void dealMessage(){
        System.out.println("CCB1081Message deal");
    }
}

class CCB1061Message extends Message{
    @Override
    public void dealMessage(){
        System.out.println("CCB1061Message deal");
    }
}

class CCBbankFactory{
    public Message createMessage(String msgType,String msg){
        if("1241".equals(msgType)){
            CCB1241Message message = JSON.parseObject(msg,CCB1241Message.class);
            return message;
        }else if("1081".equals(msgType)){
            CCB1081Message message = JSON.parseObject(msg,CCB1081Message.class);
            return message;
        }else if("1061".equals(msgType)){
            CCB1061Message message = JSON.parseObject(msg,CCB1061Message.class);
            return message;
        }else{
            return null;
        }
    }
}

