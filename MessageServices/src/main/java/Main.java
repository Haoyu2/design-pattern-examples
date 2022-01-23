public class Main {
    public static void main(String[] args) {
        NotifierRegister notifierRegiester = new NotifierRegister();
        notifierRegiester.register();
        notifierRegiester.register();


        String mes = "Hi, nice to meet you";
        Notifier[] notifiers = new Notifier[]{SMSNotifier.getInstance(), EmailNotifier.getInstance() };
        for (Notifier notifier: notifiers ){
            notifier.sendAll(mes);
        }
        notifierRegiester.close();
    }
}
