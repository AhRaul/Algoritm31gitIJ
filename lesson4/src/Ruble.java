//рубли
public class Ruble implements RusMoney {
    private final double quantity;

    public Ruble(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getRusMoney() {
        return quantity;
    }
}
