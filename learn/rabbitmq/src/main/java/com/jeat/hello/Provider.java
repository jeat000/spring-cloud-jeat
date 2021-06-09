package com.jeat.hello;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author chenjian
 * @desc 生产者
 * @date Created in 2021/6/9 22:57
 */
public class Provider {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory conn = new ConnectionFactory();
        conn.setHost("106.15.189.199");
        conn.setPort(5672);
        conn.setUsername("jeat");
        conn.setPassword("jeat");
        conn.setVirtualHost("local");
        Connection connection = conn.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("hello",false,false,false,null);

        String msg = "this is msg!!";
        channel.basicPublish("","hello",null,msg.getBytes());

        channel.close();
        connection.close();
        conn.clone();

        System.out.println("发送成功");
    }
}
