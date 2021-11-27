package HW1;

import interfaces.Action;
import interfaces.Jumpable;

public class Wall extends Barrier {

    public int doAction = 5;
    public void jumpOverWall(Jumpable jumpable){
        if (doAction == 5 ) {
            jumpable.jump();
            System.out.println("Участник  смог пройти препядствие стена");
        }else {
            System.out.println("Участник не смог пройти препядствие стена");
        }
    }


    @Override
   public void doAction(Action action ) {
        if (doAction == 5 ) {
            action.jump();
            System.out.println("Участник  смог пройти препядствие стена");
        }else {
            System.out.println("Участник не смог пройти препядствие стена");
        }

    }
}
