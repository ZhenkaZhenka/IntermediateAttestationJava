package Classes;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    String path = "Log/log.txt";
    String drawingPath = "File of drawing.txt";
    /* Логирование создания игрушки*/
    public Toy creationToyLog(Toy toy) throws IOException {
        FileWriter fw = new FileWriter(path, true);
        fw.append(getDate() + " " + toy.toString() + " был добавлен в магазин." + "\n");
        fw.flush();
        return toy;
    }
    /* Логирование добавления игрушки в очередь на розыгрыш*/
    public Toy additionToDrawing(Toy toy) throws IOException {
        FileWriter fw = new FileWriter(path, true);
        fw.append(getDate() + " " + toy.toString() + " был добавлен в очередь на розыгрыш." + "\n");
        fw.flush();
        return toy;
    }
    /* Логирование розыгрыша игрушки в log.txt*/
    public Toy loggingOfDrawing(Toy toy) throws IOException {
        FileWriter fw = new FileWriter(path, true);
        fw.append(getDate() + " " + toy.toString() + " был разыгран." + "\n");
        fw.flush();
        return toy;
    }
    /* Запись разового розыгрыша игрушки в файл  File of drawing.txt */
    public Toy writingOfDrawing(Toy toy) throws IOException {
        FileWriter fw = new FileWriter(drawingPath,true);
        fw.append(getDate() + toy.getName() + " был разыгран.\n");
        fw.flush();
        return toy;
    }
    /* Логирование изменения количества игрушки*/
    public Toy logginfOfAToyAmountChange(Toy toy, int number) throws IOException{
        FileWriter fw = new FileWriter(path,true);
        fw.append(getDate() + " " + toy.toString() + " было изменено количество игрушек на " + number + "\n");
        fw.flush();
        return toy;
    }
    /* Логирование изменения количества игрушки*/
    public Toy logginfOfAToyOddsChange(Toy toy, int number) throws IOException{
        FileWriter fw = new FileWriter(path,true);
        fw.append(getDate() + " " + toy.toString() + " был изменен шанс на выйгрыш на " + number + "\n");
        fw.flush();
        return toy;
    }
    /* Метод получения текущей даты и времени для логирования*/
    private String getDate(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
