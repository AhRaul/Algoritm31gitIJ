//Aдаптер доллара в российскую валюту
public class RusificDollar extends Dollar implements RusMoney {

    public RusificDollar(double quantity) {
        super(quantity);
    }

    @Override
    public double getRusMoney() {
        return getDollar()*63.86;       //курс доллара на 08/07/2019 13:25 согласно google
    }
}
