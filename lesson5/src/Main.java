public class Main {
    public static void main(String[] args) {
        Holder giver = new Holder();
        Holder taker = new Holder();

        giver.setMoney(10000);
        taker.setMoney(5000);

        System.out.println("у giver " + giver.getMoney() + " денег");
        System.out.println("у taker " + taker.getMoney() + " денег");

        MyTranzaction tranzaction1 = new MyTranzaction(giver, taker, 6000);

        System.out.println("у giver " + giver.getMoney() + " денег");
        System.out.println("у taker " + taker.getMoney() + " денег");

        MyTranzaction tranzaction2 = new MyTranzaction(giver, taker, 6000);

        System.out.println("у giver " + giver.getMoney() + " денег");
        System.out.println("у taker " + taker.getMoney() + " денег");
    }
}

//результат выполнения программы:
//у giver 10000.0 денег
//у taker 5000.0 денег
//Транзакция удалась
//Передано 6000.0
//у giver 4000.0 денег
//у taker 11000.0 денег
//Транзакция не удалась
//у giver 4000.0 денег
//у taker 11000.0 денег