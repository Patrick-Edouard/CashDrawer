package ch.qiminfo.cashdrawer.client.worker;

import org.apache.http.HttpResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by patrick-edouard on 3/13/16.
 */
public class Main {

    public static void main(String[] args){

        Random random = new Random();

        List<Thread> workerPool = new ArrayList<Thread>();

        HttpWorker httpWorker;

        for(int i = 0; i<=500; ++i){
            httpWorker = new HttpWorker();
            httpWorker.setAmountPaid(random.nextDouble()*10);
            httpWorker.setPrice(random.nextDouble() * 6);
            workerPool.add(new Thread(httpWorker));
        }

        for(Thread worker : workerPool){
            worker.run();
        }

    }
}
