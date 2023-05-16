package Classes;

public class Toy extends ToyShop{
    int id;
    String name;
    int amount = 0;
    int odds;

    public Toy() {
        id = createId();
        name = getString("Введите название игрушки:");
        amount = getInteger("Введите количество игрушек");
        odds = getInteger("Введите шанс выпадения игрушки");
    }

    public Toy(int id, String name,int amount, int odds){
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.odds = odds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getOdds() {
        return odds;
    }

    public void setOdds(int odds) {
        this.odds = odds;
    }

    private int createId(){
        while(true){
            int id = getInteger("Введиет id игрушки:");
            if (checkId(id)){
                return id;
            }
        }
    }

    private boolean checkId(int id){
        for (Toy toy : listOfToy) {
            if (toy.id == id){
                System.out.println("Такой ID уже существует, введите другой ID");
                return false;
            }
        }
        return true;
    }

    public void decreaseAmount(){
        amount -= 1;
    }

    @Override
    public String toString() {
        return "id =" + id +
                ", name = " + name +
                ", amount = " + amount +
                ", odds = " + odds + "%";
    }
}
