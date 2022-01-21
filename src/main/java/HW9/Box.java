package HW9;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    public List<T> fruitBox;

    @Override
    public String toString() {
        return "Box{" +
                "fruitBox=" + fruitBox +
                '}';
    }

    public Box() {
        this.fruitBox = new ArrayList<>();

    }

    public void addFruit(T fruit){
        fruitBox.add(fruit);
    }
    public int getWeight(){
        if (fruitBox.isEmpty()){
            return 0;
        }else {
            if (fruitBox.get(0) instanceof Apple){
                return fruitBox.size() ;
            }else {
                return fruitBox.size() *2;
            }
        }
    }

    public boolean compare(Box<? extends Fruit> box){

        return getWeight() == box.getWeight();
    }
    public void foo(Box<T> box){
        fruitBox.addAll(box.fruitBox);
        box.fruitBox.clear();

    }
}
