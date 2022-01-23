public interface Notifier {
    void sendAll(String msg);
    void sendOne(Customer customer, String msg);
}
