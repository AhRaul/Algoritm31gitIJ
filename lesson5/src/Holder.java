public class Holder {

    private double money = 0;

    public Holder() {

    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public Memento saveState() {
        return new Memento(money);
    }

    public void returnState(Memento memento) {
        this.money = memento.getState();
    }
}
