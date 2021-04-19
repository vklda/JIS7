package homework.inheritance.animals;

import java.util.Objects;

public abstract class Mammal extends Animal {
    private boolean carnivora;
    private int speed;

    public Mammal(String name, int age, int weight, boolean carnivora, int speed) {
        super(name, age, weight);
        this.carnivora = carnivora;
        this.speed = speed;
    }

    public Mammal() {
        super();
    }

    @Override
    public String eat() {
        if (this.isCarnivora()) {
            return super.eat() + " meat";
        } else return super.eat() + " some vegetables";
    }

    @Override
    public String move() {
        return super.move() + " with a speed of " + this.getSpeed();
    }

    public abstract String play();

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isCarnivora() {
        return carnivora;
    }

    public void setCarnivora(boolean carnivora) {
        this.carnivora = carnivora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Mammal mammal = (Mammal) o;
        return carnivora == mammal.carnivora && speed == mammal.speed;
    }

    @Override
    public String toString() {
        return "Mammal{" +
                "name='" + this.getName() + '\'' +
                ", age=" + this.getName() +
                ", weight=" + this.getWeight() +
                "carnivora=" + carnivora +
                ", speed=" + speed +
                '}';
    }
}
