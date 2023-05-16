import Classes.Controller;
import Classes.DrawingOfToy;
import Classes.ToyShop;
import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {
        ToyShop ts = new ToyShop();
        DrawingOfToy dr = new DrawingOfToy();
        Controller c = new Controller();

        getToys(ts);
        getDrawing(ts, dr);

        c.Start(ts, dr);

    }
    /*Создание 10 игрушек*/
    public static void getToys(ToyShop ts) throws IOException {
        ts.addToy(1, "Мягкая морковь",30, 60);
        ts.addToy(2, "Погремушка", 45, 20);
        ts.addToy(3, "Собака танцующая", 40, 30);
        ts.addToy(4, "Ворона желтая", 70, 33);
        ts.addToy(5, "Кукла строитель", 50, 27);
        ts.addToy(6, "Семена бобов", 70, 50);
        ts.addToy(7, "Тучка веселая", 60, 70);
        ts.addToy(8, "Кукла трудовик", 10, 12);
        ts.addToy(9, "Молодая картошка",5,  44);
        ts.addToy(10, "Набор инструментов для ремонта самосвала", 55, 29);
    }
    /*Добавление 10 случайных игрушек в очередь*/
    public static void getDrawing(ToyShop ts, DrawingOfToy dr) throws IOException {
        Controller c = new Controller();
        c.takeAToyForADraw(ts, dr);
        c.takeAToyForADraw(ts, dr);
        c.takeAToyForADraw(ts, dr);
        c.takeAToyForADraw(ts, dr);
        c.takeAToyForADraw(ts, dr);
        c.takeAToyForADraw(ts, dr);
        c.takeAToyForADraw(ts, dr);
        c.takeAToyForADraw(ts, dr);
        c.takeAToyForADraw(ts, dr);
        c.takeAToyForADraw(ts, dr);
    }
}
