package Classes;

import java.io.IOException;
import java.util.PriorityQueue;

public class DrawingOfToy {
    PriorityQueue<Toy> drawing;
    /*  Первым в очереди будет игрушки в наибольшим шансом на выйгрыш*/
    public DrawingOfToy(){
        drawing = new PriorityQueue<Toy>(new OddsComparator());
    }

    public void Add(Toy toy) throws IOException {
        Logger log = new Logger();
        this.drawing.add(log.additionToDrawing(toy));
    }

    public void Draw() throws IOException {
        Logger log = new Logger();
        if (drawing.peek() == null){
            System.out.println("Drawing is empty");
            return;
        }
        Toy toy = drawing.peek();
        log.loggingOfDrawing(toy);
        log.writingOfDrawing(toy);
        System.out.println("Разыграна игрушка: " + drawing.poll());
        toy.decreaseAmount();
    }
}
