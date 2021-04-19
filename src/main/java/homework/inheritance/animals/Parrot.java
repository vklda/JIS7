package homework.inheritance.animals;

import java.util.Objects;

public class Parrot extends Bird {
    private boolean isSpeaking;

    public Parrot(String name, int age, int weight, int speed, boolean isSpeaking) {
        super(name, age, weight, true, speed);
        this.isSpeaking = isSpeaking;
    }

    public Parrot() {
        super();
    }

    @Override
    public String voice() {
        if (this.isSpeaking()) {
            return this.getName() + " is repeating your words";
        }
        return this.getName() + " is singing";
    }

    @Override
    public String eat() {
        return super.eat() + " and parrot food";
    }

    public boolean isSpeaking() {
        return isSpeaking;
    }

    public void setSpeaking(boolean speaking) {
        isSpeaking = speaking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Parrot parrot = (Parrot) o;
        return isSpeaking == parrot.isSpeaking;
    }

    @Override
    public String toString() {
        return "Parrot{" +
                "name='" + this.getName() + '\'' +
                ", age=" + this.getAge() +
                ", weight=" + this.getWeight() +
                ", speed=" + this.getSpeed() +
                ", isSpeaking=" + isSpeaking +
                '}';
    }
}
