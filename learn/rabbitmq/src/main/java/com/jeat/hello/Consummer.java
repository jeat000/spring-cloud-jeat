package com.jeat.hello;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author chenjian
 * @desc 消费者
 * @date Created in 2021/6/9 23:07
 */
public class Consummer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory conn = new ConnectionFactory();
        conn.setHost("106.15.189.199");
        conn.setPort(5672);
        conn.setUsername("jeat");
        conn.setPassword("jeat");
        conn.setVirtualHost("local");
        Connection connection = conn.newConnection();
        final Channel channel = connection.createChannel();
        channel.queueDeclare("hello",false,false,false,null);

        channel.basicConsume("hello", false , new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String jsonSMS = new String(body);
                System.out.println("SMSSender1-短信发送成功:" + jsonSMS);

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                channel.basicAck(envelope.getDeliveryTag() , false);
            }
        });
    }
}
