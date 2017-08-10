//package com.earyant.commentdatabase;
//
//import com.earyant.commentdatabase.redis.AquiredLockWorker;
//import com.earyant.commentdatabase.redis.RedisLocker;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Random;
//import java.util.concurrent.CountDownLatch;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class CommentDatabaseApplicationTests {
//
//
//    @Autowired
//    RedisLocker distributedLocker;
////    @RequestMapping(value = "/redlock")
//
//    @Test
//    public void testRedlock() throws Exception{
//
//        CountDownLatch startSignal = new CountDownLatch(1);
//        CountDownLatch doneSignal = new CountDownLatch(5);
//        for (int i = 0; i < 5; ++i) { // create and start threads
//            new Thread(new Worker(startSignal, doneSignal)).start();
//        }
//        startSignal.countDown(); // let all threads proceed
//        doneSignal.await();
//        System.out.println("All processors done. Shutdown connection");
////        return "redlock";
//    }
//
//    class Worker implements Runnable {
//        private final CountDownLatch startSignal;
//        private final CountDownLatch doneSignal;
//
//        Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
//            this.startSignal = startSignal;
//            this.doneSignal = doneSignal;
//        }
//
//        public void run() {
//            try {
//                startSignal.await();
//                distributedLocker.lock("test",new AquiredLockWorker<Object>() {
//
//                    @Override
//                    public Object invokeAfterLockAquire() {
//                        doTask();
//                        return null;
//                    }
//
//                });
//            }catch (Exception e){
//
//            }
//        }
//
//        void doTask() {
//            System.out.println(Thread.currentThread().getName() + " start");
//            Random random = new Random();
//            int _int = random.nextInt(200);
//            System.out.println(Thread.currentThread().getName() + " sleep " + _int + "millis");
//            try {
//                Thread.sleep(_int);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + " end");
//            doneSignal.countDown();
//        }
//    }
//
//
//	@Test
//	public void contextLoads() {
//	}
//
//}
