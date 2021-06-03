package com.jeat.learn.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *  jdk动态代理
 *
 *  别乱动我代码，水很深，你把握不住
 * @ClassName MyInvocationHandler
 * @Author chenjian
 * @Date 2021-06-03 10:55
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target){
        this.target=target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("--动态代理--执行之前--");
        Object invoke = method.invoke(target, args);
        System.out.println("--动态代理--执行之后--");
        return invoke;
    }

    public static void main(String[] args) throws Exception {
        /*// 1、生成$Proxy0的class文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles",true);
        // 2、获取动态代理类
        Class<?> proxyClass = Proxy.getProxyClass(UserService.class.getClassLoader(), UserService.class);
         // 3、获得代理类的构造函数，并传入参数类型InvocationHandler.class
        Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
        // 4、通过构造函数来创建动态代理对象，将自定义的InvocationHandler实例传入
        UserService userService =(UserService) constructor.newInstance(new MyInvocationHandler(new UserServiceImpl()));
         // 5、通过代理对象调用目标方法
        userService.say();*/

        UserService o =(UserService) Proxy.newProxyInstance(UserService.class.getClassLoader(),new Class[]{UserService.class} , new MyInvocationHandler(new UserServiceImpl()));
        o.say();
    }

}
