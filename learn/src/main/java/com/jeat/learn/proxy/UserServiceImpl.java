package com.jeat.learn.proxy;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName UserServiceImpl
 * @Author chenjian
 * @Date 2021-06-03 10:46
 */
public class UserServiceImpl implements UserService {

    public UserServiceImpl(){
        System.out.println("构造函数");
    }

    @Override
    public void say() {
        System.out.println("say 方法执行！");
    }
}
