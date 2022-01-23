import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailNotifier extends Publisher implements Notifier{
    private static volatile EmailNotifier emailNotifier;
    ExecutorService executorService = Executors.newCachedThreadPool();

    public static EmailNotifier getInstance(){
        if (emailNotifier == null) emailNotifier = new EmailNotifier();
        return emailNotifier;
    }

    @Override
    public void sendAll(String msg) {
        for (Subscriber subscriber : emailNotifier.subscribers.keySet()){
            executorService.submit(() -> sendOne(subscriber, msg));
        }
    }

    @Override
    public void sendOne(Subscriber customer, String msg) {
        System.out.println("Via email send " + msg + " to " + customer.toString());
    }

    @Override
    public String toString() {
        return "Email Notifier";
    }
}
