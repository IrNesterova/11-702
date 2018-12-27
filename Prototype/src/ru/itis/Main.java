package ru.itis;

public class Main {

    public static void main(String[] args) {
        Robot robot = new Robot();
        robot.talk = "I am robot!";
        robot.walk = "I am walking!";
        robot.fight = "FEAR ME";
        Robot robot1 = (Robot) robot.clone();
        System.out.println(robot.walk);
        System.out.println(robot1.walk);
    }
}
