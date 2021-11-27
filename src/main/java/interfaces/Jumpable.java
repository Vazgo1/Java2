package interfaces;

import HW1.Cat;
import HW1.Human;
import HW1.Robot;
import HW1.Teem;

public interface Jumpable {

     default void jump(){
          System.out.println("Побежал");
     }




}

