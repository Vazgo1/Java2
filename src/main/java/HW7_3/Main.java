package HW7_3;

import HW7_3.myTesting.TestsHandler;

public class Main {
    public static void main(String[] args) {

        ClassForTesting classForTesting = new ClassForTesting();
        TestsHandler.start(classForTesting.getClass());


        System.out.println();
        ClassExplorer.outClassInfo(String.class);
    }
}
