package com.cloud.sample.singleton;

/**
 * @ClassName LazySingleton
 * @Description
 * @Author Administrator
 * @DATE 2018/10/18 13:13
 */
public class LazySingleton {

    private static LazySingleton singleton;

    private LazySingleton(){}

    /**
     * 懒汉模式，非线程安全
     * @return
     * 1、懒汉式，线程不安全
     * 是否 Lazy 初始化：是
     *
     * 是否多线程安全：否
     *
     * 实现难度：易
     *
     * 描述：这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
     * 这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。
     */
    public static LazySingleton getInstance(){
        if(singleton == null){
            return new LazySingleton();
        }
        return singleton;
    }


    /**
     * 懒汉模式,线程安全
     * @return
     * 、懒汉式，线程安全
     * 是否 Lazy 初始化：是
     *
     * 是否多线程安全：是
     *
     * 实现难度：易
     *
     * 描述：这种方式具备很好的 lazy loading，能够在多线程中很好的工作，但是，效率很低，99% 情况下不需要同步。
     * 优点：第一次调用才初始化，避免内存浪费。
     * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
     * getInstance() 的性能对应用程序不是很关键（该方法使用不太频繁）。
     */
    public static synchronized LazySingleton getThreadSafeInstance(){
        if(singleton == null){
            return new LazySingleton();
        }
        return singleton;
    }
}
