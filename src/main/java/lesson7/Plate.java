package lesson7;

public class Plate {

    int food;
    int increaseFood;

    public Plate(int food,int increaseFood) {
        this.food = food;
        this.increaseFood= increaseFood;
    }
    public void decreaseFood (int n){
        food -=n;

    }

    public void addFood (int increaseFood){
        food +=increaseFood;
    }

    public void info (){
        System.out.println( "Plate: " + food);
    }

}
