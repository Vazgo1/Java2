package HW1;

import interfaces.Action;

public class Robot implements Action {
    protected String name;

    public Robot (String name){


        this.name = name;
    }




    public String getName() {
        return name;
    }


    public void run() {
        System.out.println("Робот "+ name + " побежал");

    }


    public void jump() {
        System.out.println("Робот " + name + " прыгнул.");


    }
}

