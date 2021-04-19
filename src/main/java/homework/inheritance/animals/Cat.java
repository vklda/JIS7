package homework.inheritance.animals;

import java.util.Objects;

public class Cat extends Mammal {
    private boolean isSharpClaws;

    public Cat(String name, int age, int weight, int speed, boolean isSharpClaws) {
        super(name, age, weight, true, speed);
        this.isSharpClaws = isSharpClaws;
    }

    public Cat() {
        super();
    }

    @Override
    public String play() {
        if (this.isSharpClaws()) {
            return this.getName() + " is scratching all around";
        }
        return this.getName() + " is running like crazy";
    }

    @Override
    public String eat() {
        return super.eat() + " or 'cat's food'";
    }

    @Override
    public String voice() {
        return this.meow();
    }

    private String meow() {
        return this.getName() + " is meowing. That's so cute";
    }

    public boolean isSharpClaws() {
        return isSharpClaws;
    }

    public void setSharpClaws(boolean sharpClaws) {
        isSharpClaws = sharpClaws;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cat cat = (Cat) o;
        return isSharpClaws == cat.isSharpClaws;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + this.getName() + '\'' +
                ", age=" + this.getAge() +
                ", weight=" + this.getWeight() +
                ", speed=" + this.getSpeed() +
                ", isSharpClaws=" + isSharpClaws +
                '}';
    }
}
