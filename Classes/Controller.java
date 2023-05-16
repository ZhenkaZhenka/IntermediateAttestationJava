package Classes;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Controller {
    /*НАчало программы взаимодествия с пользователем через терминал*/
    public void Start(ToyShop ts, DrawingOfToy dr) throws IOException {
        boolean mark = true;
        System.out.println("Здравствуй, мой дорогой друг!\n" +
                "Сейчас у тебя повилась уникальная возможность\n" +
                "поуправлять моим магазином.\n");
        while(mark){
            System.out.println("1. Добавить игрушку в магазин\n" +
                    "2. Изменить количество одной игрушки\n" +
                    "3. Изменить шанс на выйгрыш одной игрушки\n" +
                    "4. Посмотреть все игрушки в магазине\n" +
                    "5. Добавить игрушку в розыгрыш призов(случайным образом)\n" +
                    "6. Произвести розыгрыш, но только если ты добавил туда игрушки\n" +
                    "7. Хочу закончить работу с магазином\n");
            int number = getInteger("Выберите одно из предложенных действий:");
            mark = action(number, ts, dr);
        }
    }
    /*Выполнения команды, заданной пользователем*/
    private boolean action(int number, ToyShop ts, DrawingOfToy dr) throws IOException {
        switch(number){
            case 1:
                ts.addToy();
                return true;
            case 2:
                ts.changeAmountOfToy();
                return true;
            case 3:
                ts.changeOddsOfToy();
                return true;
            case 4:
                ts.print();
                return true;
            case 5:
                takeAToyForADraw(ts, dr);
                return true;
            case 6:
                dr.Draw();
                return true;
            case 7:
                System.out.println("Всего наилучшего, до свидания!");
                return false;
            default:
                System.out.println("Такого варианта пока нет, выберите из предложенных.");
                return true;
        }
    }
/*
Случайным образом выбирает игрушку и добавляет в очередь на розыгрыш
*/
    public void takeAToyForADraw(ToyShop ts, DrawingOfToy dr) throws IOException {
        Logger log = new Logger();
        Random r = new Random();
        while(true){
            int index = r.nextInt(ts.listOfToy.size());
            if (checkAmount(index, ts)){
                Toy toy = ts.listOfToy.get(index);
                dr.Add(toy);
                System.out.println("Случайным образом в розыгрыш была добавлена игрушка:\n " +
                        toy);
                return;
            }
        }
    }
    /*
    ПРоверка количества игрушек, если колличество игрушек <0, игрушка добавлена не будет
    **/
    public boolean checkAmount(int index, ToyShop list){
        Toy toy = list.listOfToy.get(index);
        if (toy.amount > 0){
            return true;
        }
        else {
            return false;
        }
    }
/*
Считывание целого числа из консоли
* */
    private int getInteger(String message){
        boolean mark = true;
        System.out.println(message);
        Scanner in = new Scanner(System.in);
        while(mark) {
            try {
                int number = in.nextInt();
                return number;
            } catch(Exception e){
                System.out.println("Вы ввели не число, попробуйте еще");
            }
        }
        in.close();
        return 0;
    }
}
