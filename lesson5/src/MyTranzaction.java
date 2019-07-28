public class MyTranzaction {

 private Holder giver;                //дающий держатель счета
 private Holder taker;                //берущий держатель счета
 private Caretaker caretakerGiver;    //информация для отката у дающий
 private Caretaker caretakerTaker;    //информация для отката у берущий
 private double howMuch;              //сколько денег передается

 /**
  * При создании конструктора, сразу запускается транзакция, в конструкторе проверяется успех,
  * и в случае неудачи, производится откат операции.
  * @param giver
  * @param taker
  * @param howMuch
  */
 public MyTranzaction(Holder giver, Holder taker, double howMuch) {
  this.giver = giver;
  this.caretakerGiver = new Caretaker();
  this.taker = taker;
  this.caretakerTaker = new Caretaker();
  this.howMuch = howMuch;

  boolean success = startTranzaction();

  if(success) {
   caretakerGiver.setMemento(this.giver.saveState());         //в случае успеха, из памяти стирается старый результат, записывается новый
   caretakerTaker.setMemento(this.taker.saveState());         //в случае успеха, из памяти стирается старый результат, записывается новый
   System.out.println("Транзакция удалась \nПередано " + howMuch);
  } else {
   giver.setMoney(caretakerGiver.getMemento().getState());    //откат операции
   taker.setMoney(caretakerTaker.getMemento().getState());    //откат операции
   System.out.println("Транзакция не удалась");
  }
 }

 /**
  * действия транзакции
  * @return true - если успех ; false если неудача
  */
 private boolean  startTranzaction() {
  caretakerGiver.setMemento(this.giver.saveState());
  caretakerTaker.setMemento(this.taker.saveState());

  if(giver.getMoney() < howMuch) {
   return false;
  } else {
   giver.setMoney(giver.getMoney() - howMuch);
   taker.setMoney(taker.getMoney() + howMuch);
   return true;
  }
 }

}
