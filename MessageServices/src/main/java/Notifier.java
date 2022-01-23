public interface Notifier {
    void sendAll(String msg);
    void sendOne(Subscriber customer, String msg);
}
