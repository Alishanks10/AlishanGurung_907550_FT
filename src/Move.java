import java.util.ArrayList;

public class Move {


    /* *************************************** */
    // write your code here
    private final int totalBoxes;
    private ArrayList<Box> addItem;
    private ArrayList<Box> addBox;

    public Move(int totalBoxes) {
        this.totalBoxes = totalBoxes;
        this.addItem = new ArrayList<>();
        this.addBox = new ArrayList<>();
    }

    public int getTotalBoxes() {
        return totalBoxes;
    }

    public void addItem(Box box){
        addItem.add(box);
    }

    public void addBox(Box box){
        try{addBox.add(box);}
        catch(NullPointerException ex){
            ex.getMessage();
        }
    }

    public String find(String item){
        return item;
    }

    public void print(){
        System.out.println("All the objects in the boxes are: ");

    }

    /* *************************************** */

    public static void main(String[] args) {
        // We create a move that will hold 2 main boxes
        Move move = new Move(2);

        /*
         * We create and then fill 3 boxes
         * Arguments of the constructor of Box:
         * argument 1: number of items (simple items/objects or box) that the box can hold
         * argument 2: box number
         */

        // box 1 contains scissors
        Box box1 = new Box(1, 1);
        box1.addItem(new SingleObject("scissors"));

        // box 2 contains one book
        Box box2 = new Box(1, 2);
        box2.addItem(new SingleObject("book"));

        // box 3 contains one compass
        // and one box containing one scarf
        Box box3 = new Box(2, 3);
        box3.addItem(new SingleObject("compass"));
        Box box4 = new Box(1, 4);
        box4.addItem(new SingleObject("scarf"));
//        box3.addItem(box4);

        // We add the three boxes to the first box of move - see below
        Box box5 = new Box(3, 5);
//        box5.addItem(box1);
//        box5.addItem(box2);
//        box5.addItem(box3);

        // We add one box containing 3 objects to move
        Box box6 = new Box(3, 6);
        box6.addItem(new SingleObject("pencils"));
        box6.addItem(new SingleObject("pens"));
        box6.addItem(new SingleObject("rubber"));

        // We add the two most external boxes to the move
        move.addBox(box5);
        move.addBox(box6);

        // We print all the contents of the move
        move.print();

        // We print the number of the outermost cardboard containing the item "scarf"
        System.out.println("The scarf is in the cardboard number " + move.find("scarf"));
    }
}

class Box{
    private final int totalObjects;
    private final int boxNumber;
    private ArrayList<SingleObject> sObject;

    public Box(int totalObjects, int boxNumber) {
        this.totalObjects = totalObjects;
        this.boxNumber = boxNumber;
        this.sObject = new ArrayList<>();
    }

    public int getTotalObjects() {
        return totalObjects;
    }

    public int getBoxNumber() {
        return boxNumber;
    }

    public void addItem(SingleObject singleItem){
        try{
            sObject.add(singleItem);
        } catch (NullPointerException ex){
            ex.getMessage();
        }
    }
}

class SingleObject{
    private final String item;

    public SingleObject(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public void print(){
        System.out.println(item);
    }
}