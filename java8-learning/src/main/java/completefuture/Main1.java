package completefuture;

import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by zhaocaiwen on 2017/2/27.
 */
public class Main1 {

    private Future<Integer> longrunAsyncMethod() {
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
        new Thread(()->{
            try {
                int result = longrunmethod();
                completableFuture.complete(result);
            } catch (Exception e) {
                completableFuture.completeExceptionally(e);
            }
        }).start();
        return completableFuture;
    }

    private int longrunmethod() {
        try {
            Thread.sleep(10*1000);
            //return 1;
            throw new RuntimeException("bad");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Main1 main1 = new Main1();
        Future<Integer> f = main1.longrunAsyncMethod();
        System.out.println(new Date()+"--long run called, here do sth else.");
        Integer result = f.get();//blocked
        System.out.println(new Date()+"--result="+result);
    }
}
