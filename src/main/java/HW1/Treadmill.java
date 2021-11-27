package HW1;

import interfaces.Action;
import interfaces.Runeble;

public class Treadmill extends Barrier {

    private boolean doAction;
    public void runOverWall(Runeble runeble){
        if (doAction) {
            runeble.run();
        }else {

            System.out.println(" Участник не смог пройти препядствие беговая дорожка");
        }
    }

    @Override
   public void doAction(Action action) {
        if (doAction) {
            action.run();
        }else {

            System.out.println(" Участник не смог пройти препядствие беговая дорожка");
        }

    }
}
