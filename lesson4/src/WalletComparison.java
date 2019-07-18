import java.util.ArrayList;
import java.util.List;

//теперь мы можем сравнивать в рублях, у кого в кошельке больше денег, а так-же скалдывать всё в один кошелёк
public class WalletComparison {
    public static void main(String[] args) {

        Ruble rub100 = new Ruble(100);      // купюра в 100 р
        Ruble rub500 = new Ruble(500);      // -- .. -- 500 р
        Ruble rub1000 = new Ruble(1000);    // -- .. -- 1000 р

        RusificDollar doll2 = new RusificDollar(2);     // банкнота в 2 доллара
        RusificDollar doll10 = new RusificDollar(10);   // -- .. --   10 долларов
        RusificDollar doll100 = new RusificDollar(100); // -- .. --   100 долларов

        Wallet russianManWallet = new Wallet(rub100, rub500, rub1000);               //кошелёк русского человека
        Wallet ameriсanManWallet = new Wallet(doll2, doll10, doll100);               //кошелёк американца
        Wallet travellerWallet = new Wallet(rub100, doll10, rub1000, doll100);       //кошелёк путешественника

        System.out.println("у русского в кошельке " + russianManWallet.getSummRub() + " рублей");
        System.out.println("у американца в кошельке " + ameriсanManWallet.getSummRub() + " рублей");
        System.out.println("у путешественника в кошельке " + travellerWallet.getSummRub() + " рублей");
    }
}
