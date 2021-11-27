package HW1;

import interfaces.Action;

public class App {
    public static void main(String[] args) {

        Robot robot = new Robot("Jon");
        Human human = new Human("Pavel");
        Cat cat = new Cat("Tom");
        Cat cat2 = new Cat("Gary");

        Action[] members = {robot,human,cat,cat2};

        Teem teem = new Teem("My teem",members);

        Barrier[] barrier =  {new Wall(), new Treadmill()};
        Course course = new Course(barrier);

        for (int i =0; i < course.getBarriers().length; i ++) {
            for (int j = 0; j < teem.getTeemMembers().length; j++) {

                course.getBarriers()[i].doAction(teem.getTeemMembers()[j]);

            }
        }
    }
}
