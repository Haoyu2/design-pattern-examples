import java.util.concurrent.ConcurrentHashMap;

public abstract class Publisher {
    protected ConcurrentHashMap<Subscriber, Integer> subscribers = new ConcurrentHashMap<>();
    public void subsribe(Subscriber costomer){
        subscribers.putIfAbsent(costomer, 1);
    }
    public void unsubsribe(Subscriber customer){
        subscribers.remove(customer);
    }
}
