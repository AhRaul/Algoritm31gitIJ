import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Wallet {
    List<RusMoney> banknotes = new ArrayList<>();

    public Wallet(RusMoney... banknota){
        this.banknotes.addAll(Arrays.asList(banknota));
    }

    public double getSummRub() {
        double summ = 0.0;
        for(RusMoney banknota: banknotes) {
            summ = summ + banknota.getRusMoney();
        }
        return summ;
    }
}
