package Classes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ToyShop{
    ArrayList<Toy> listOfToy;

    public ToyShop(){
        listOfToy = new ArrayList<Toy>();
    }
    public void addToy() throws IOException {
        Logger log = new Logger();
        Toy toy = new Toy();
        listOfToy.add(log.creationToyLog(toy));
    }
    public void addToy(int id, String name,int amount, int odds) throws IOException {
        Logger log = new Logger();
        Toy toy = new Toy(id, name, amount, odds);
        listOfToy.add(log.creationToyLog(toy));
    }

    public void changeAmountOfToy() throws IOException {
        print();
        Logger log = new Logger();
        int id = getInteger("Введите id игрушки из списка: ");
        for (Toy toy : listOfToy) {
            if (toy.id == id){
                int number = getInteger("Введите новое количество игрушек");
                log.logginfOfAToyAmountChange(toy, number);
                toy.setAmount(number);
                return;
            }
        }
        System.out.println("Вы ввели ID, которого нет ни у одной из игрушек");
    }

    public void changeOddsOfToy() throws IOException {
        print();
        Logger log = new Logger();
        int id = getInteger("Введите id игрушки из списка: ");
        for (Toy toy : listOfToy) {
            if (toy.id == id){
                int number = getInteger("Введите новый шанс на выйгрыш игрушки");
                log.logginfOfAToyOddsChange(toy, number);
                toy.setAmount(number);
                return;
            }
        }
        System.out.println("Вы ввели ID, которого нет ни у одной из игрушек");
    }

    public void print(){
        for (Toy toy : listOfToy) {
            System.out.println(toy.toString());
        }
    }

    protected int getInteger(String message){
        boolean mark = true;
        System.out.println(message);
        Scanner in = new Scanner(System.in);
        while(mark) {
            try {
                int number = in.nextInt();

                return number;
            } catch(Exception e){
                System.out.println("Вы ввели не число, попробуйте еще");
                return getInteger(message);
            }
        }
        return 0;
    }

    protected String getString(String message){
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        String string = in.nextLine();
        return string;
    }
}
