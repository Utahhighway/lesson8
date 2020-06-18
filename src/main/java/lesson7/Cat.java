package lesson7;

import java.util.Scanner;

public class Cat {
    private String name;
    private int appetite;
    private boolean full;
    Scanner sc = new Scanner(System.in);

    public Cat(String name, int appetite, boolean full) {
        this.appetite = appetite;
        this.name = name;
        this.full = full;
    }

    public void info() {
        System.out.println("У кота " + name + " аппетит " + appetite + ", кот сыт: " + full);
    }

    public boolean eat(Plate p) {
        if (p.food >= appetite) {
            System.out.println(name+ " поел и сыт");
            p.decreaseFood(appetite);
            full = true;
        } else {

            System.out.println(name +" голдный,еда закончилась. Сколько добавить еды в тарелку?");
            p.addFood(sc.nextInt());
            if (p.food >= appetite) {
                System.out.println(name +" поел и сыт");
                p.decreaseFood(appetite);
                full = true;
            } else {
                System.out.println(name + " голодный");
            }

        }
        return full;
    }
}
