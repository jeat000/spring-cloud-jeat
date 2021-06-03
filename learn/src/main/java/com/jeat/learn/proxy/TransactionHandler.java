package com.jeat.learn.proxy;

/**
 * 别乱动我代码，水很深，你把握不住
 * 静态代理
 * @ClassName TransactionHandler
 * @Author chenjian
 * @Date 2021-06-03 10:48
 */
public class TransactionHandler implements UserService{
    private UserService target;

    public TransactionHandler(UserService target){
        this.target=target;
    }

    @Override
    public void say() {
        System.out.println("--静态代理--执行之前--");
        target.say();
        System.out.println("--静态代理--执行之后--");
    }


    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        UserService service = new TransactionHandler(userService);
        service.say();
    }
}
