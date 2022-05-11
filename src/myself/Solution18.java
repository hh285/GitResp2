package myself;


public class Solution18 {
    private static int count = 0;
    private static final Object lock = new Object();
    /*新建两个线程
      一个处理偶数，一个处理奇数(用位运算)
      用synchronized来通信
    * */
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 10) {
                    synchronized (lock) {//通过while之后，在此等待锁
                        if ((count & 1) == 0) {
                            System.out.println(Thread.currentThread().getName() + ":" + count);
                            count++;
                        }
                    }
                }
            }
        }, "偶数").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 10) {
                    synchronized (lock) {
                        if ((count & 1) == 1) {
                            System.out.println(Thread.currentThread().getName() + ":" + count);
                            count++;
                        }
                    }
                }
            }
        }, "奇数").start();
    }
}


//public class Singleton6 {
//    private volatile static Singleton6 instance;
//    //新建对象实际有三个步骤，用volatile防止重排序
//    private Singleton6(){
//    }
//    public static Singleton6 getinstance(){
//        if(instance==null){
//            synchronized (Singleton6.class){
//                if(instance==null){
//                    instance=new Singleton6();
//                }
//            }
//        }
//        return instance;
//    }
//}//线程安全，效率高，延迟加载。
////为什么double check，安全。