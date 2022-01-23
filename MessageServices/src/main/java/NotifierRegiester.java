import java.sql.SQLOutput;
import java.util.Scanner;

public class NotifierRegiester {
    private Scanner in =  new Scanner(System.in);
    private Publisher[] publishers = new Publisher[]{SMSNotifier.getInstance(), EmailNotifier.getInstance() };

    private int getID(){
        System.out.println();
        System.out.print("Enter your ID: ");
        int id;
        while (true){
            try{
                id = Integer.parseInt(in.nextLine());
                break;
            }catch (NumberFormatException exception){
                System.out.print("Invalid number format, please Try again: ");
            }
        }

        System.out.println("Successful and your id is: " + id);
        return id;
    }
    private void regiesterNotifer(Subscriber subscriber){
        System.out.print("Enter your a notifer id: ");
        int id;
        while (true){
            try{
                id = Integer.parseInt(in.nextLine());
                if (0 <= id && id <= publishers.length){
                    Publisher publisher = publishers[id];
                    publisher.subsribe(subscriber);
                    System.out.println("Successfully subsribled in "  + publisher.toString());
                    break;
                }
                System.out.println("There is not notifer for this number");
                System.out.println("For SMS please enter 0 and for Email enter 1");


            }catch (NumberFormatException exception){
                System.out.print("Invalid number format, please Try again: ");
            }
        }
    }
    public void close(){in.close();}

    public void register(){
        int id = getID();
        Subscriber customer = new Subscriber(id);
        System.out.println("There are two types of message services SMS and Email!");
        System.out.println("For SMS please enter 0 and for Email enter 1");
        regiesterNotifer(customer);
    }

    public static void main(String[] args) {
        NotifierRegiester notifierRegiester = new NotifierRegiester();
        System.out.println(notifierRegiester.getID());
    }
}
