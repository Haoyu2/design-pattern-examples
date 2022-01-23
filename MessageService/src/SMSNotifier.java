import java.util.ArrayList;
import java.util.List;

public class SMSNotifier extends Publisher implements Notifier{
    private static volatile SMSNotifier smsNotifier;
//    private
    public static SMSNotifier getInstance(){
        if (smsNotifier != null) smsNotifier = new SMSNotifier();
        return smsNotifier;
    }

    @Override
    public void sendAll(String msg) {

    }

    @Override
    public void sendOne(Customer customer, String msg) {
        System.out.println("Send " + msg + " to " + customer.toString());

    }

    @Override
    public String toString() {
        return "SMS Notifier";
    }
}
