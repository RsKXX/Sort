package com.design.singleton;

/**
 * 单例设计模式
 * 三种：懒汉式单例、饿汉式单例、登记式单例（可忽略）
 * 特点：
 *      1、单例类只能有一个实例。
 *      2、单例类必须自己创建自己的唯一实例。
 *      3、单例类必须给所有其他对象提供这一实例
 *饿汉式：类初始化已经自动实例化，天生线程安全
 */
public class Singleton {
    private Singleton(){}
    private static final Singleton single = new Singleton();
    //静态工厂方法
    public static Singleton getInstance(){
        return single;
    }
}
