package HW6_3;


import org.junit.jupiter.api.Assertions;
import HW6_3.Task2;
import org.junit.jupiter.api.Test;

public class Task2Test {
    private Task2 task2;

    @Test
    public void task2Test1() {
        task2 = new Task2();
        int[] verifiableArray = {1, 2, 4, 0, 4, 2, 4, 0,};
        int[] correctResult = {0};
        Assertions.assertArrayEquals(correctResult, task2.copyAfter4(verifiableArray));
    }

    @Test
    public void task2Test2() {
        task2 = new Task2();
        int[] verifiableArray = {4, 2, 4, 0, 4, 2, 5, 0,};
        int[] correctResult = {2, 5, 0};
        Assertions.assertArrayEquals(correctResult, task2.copyAfter4(verifiableArray));
    }

    @Test
    public void task2Test3() {
        task2 = new Task2();
        int[] verifiableArray = {1, 4, 9, 0, 1, 2, 5, 0};
        int[] correctResult = {9, 0, 1, 2, 5, 0};
        Assertions.assertArrayEquals(correctResult, task2.copyAfter4(verifiableArray));
    }

    @Test
    public void task2Test4() {
        task2 = new Task2();
        int[] verifiableArray = {1, 2, 4, 0, 4, 9, 0, 4, 2, 5, 0};
        int[] correctResult = {2, 5, 0};
        Assertions.assertArrayEquals(correctResult, task2.copyAfter4(verifiableArray));
    }
}
