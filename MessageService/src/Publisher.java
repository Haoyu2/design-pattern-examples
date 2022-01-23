import java.util.HashSet;
import java.util.Set;

public abstract class Publisher {
    protected Set<Customer> subscribers = new HashSet<>();
    public void subsribe(Customer costomer){
        subscribers.add(costomer);
    }
    public void unsubsribe(Customer customer){
        subscribers.remove(customer);
    }
}
