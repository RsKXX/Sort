package com.design.singleton;

/**
 * 懒汉式：线程不安全
 *
 */
public class LazySingleton {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private LazySingleton(){};
    private static LazySingleton single = null;
    //静态工厂实现
    public static LazySingleton getInstance(){
        if(single==null){
            synchronized(LazySingleton.class){
                if(single==null){
                    single = new LazySingleton();
                }
            }
        }
        return single;
    }
    /**
     * 因为线程不安全所有需要进行改进
     * 1：在getInstance方法上加同步
     * public static synchronized LazySingleton getInstance(){
     *         if(single==null){
     *             single = new LazySingleton();
     *         }
     *         return single;
     *     }
     * 2:双重检查锁定
     * public static LazySingleton getInstance(){
     *         if(single==null){
     *              synchronized(LazySingleton.class){
     *                  if(single==null){
     *                      single = new LazySingleton();
     *                  }
     *              }
     *         }
     *         return single;
     *     }
     * 2:静态内部类
     * public class Singleton {
     *     private static class LazyHolder {
     *        private static final Singleton INSTANCE = new Singleton();
     *     }
     *     private Singleton (){}
     *     public static final Singleton getInstance() {
     *        return LazyHolder.INSTANCE;
     *     }
     * }
     */
}
