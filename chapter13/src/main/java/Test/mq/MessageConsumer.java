package Test.mq;

import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;
import java.util.concurrent.TimeUnit;

public class MessageConsumer {
    public static void main(String[] args) throws JMSException {
        try{
            // 创建一个连接工厂
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
            // 通过连接工厂创建一个连接
            Connection connection = connectionFactory.createConnection();
            //3、启动连接（这里需要手动启动）
            connection.start();
            //3、创建会话 Session （参数一 transacted：是否是事务  参数二：自动确认）
            Session session = connection.createSession(Boolean.FALSE, Session.CLIENT_ACKNOWLEDGE);
            /**
             * 4、创建消息目的:
             * 第一种 Queue：点对点消息
             * 第二种 Topic：广播式消息
             */
            Destination queue = session.createQueue("JMSXGroupID");
            // 5、创建消息生产者
            javax.jms.MessageConsumer messageConsumer = session.createConsumer(queue,"JMSXGroupID='B'");
            System.out.println("接收消息之前123");
//      System.out.println("收到消息=" + message.getText());
            messageConsumer.setMessageListener(new MessageListener(){
                @Override
                public void onMessage(Message message) {
                    try {
                        if(message instanceof TextMessage ){
                            TextMessage textMessage = (TextMessage)message;
                            System.out.println("收到消息123=" + textMessage.getText());
                        }else{
                            System.out.println("收到消息格式有点问题");
                        }
                        message.acknowledge();
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });
            System.out.println("接收消息之后123");
            //强制阻塞线程，让监听器持续加载
            Thread.currentThread().wait();
            messageConsumer.close();
            session.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
