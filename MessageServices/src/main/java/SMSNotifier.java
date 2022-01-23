import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SMSNotifier extends Publisher implements Notifier{
    private static volatile SMSNotifier smsNotifier;
    ExecutorService executorService = Executors.newCachedThreadPool();

    public static SMSNotifier getInstance(){
        if (smsNotifier == null) smsNotifier = new SMSNotifier();
        return smsNotifier;
    }

    @Override
    public void sendAll(String msg) {
        for (Subscriber subscriber : smsNotifier.subscribers.keySet()){
            executorService.submit(() -> sendOne(subscriber, msg));
        }
    }

    @Override
    public void sendOne(Subscriber customer, String msg) {
        System.out.println("Via SMS, send " + msg + " to " + customer.toString());
    }
    public String toString() {
        return "SMS Notifier";
    }

}
