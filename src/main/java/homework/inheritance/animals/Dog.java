package homework.inheritance.animals;

public class Dog extends Mammal {
    private boolean isFriendly;

    public Dog(String name, int age, int weight, int speed, boolean isFriendly) {
        super(name, age, weight, true, speed);
        this.isFriendly = isFriendly;
    }

    public Dog() {
        super();
    }

    @Override
    public String play() {
        if (this.isFriendly()) {
            return "Good Boy " + this.getName() + " is playing with a ball";
        } else return this.bite();
    }

    private String bite() {
        return "Bad Boy " + this.getName() + " is biting";
    }

    @Override
    public String voice() {
        return bark();
    }

    private String bark() {
        return this.getName() + " is barking";
    }

    @Override
    public String eat() {
        return super.eat() + " or 'dog's food'";
    }

    public boolean isFriendly() {
        return isFriendly;
    }

    public void setFriendly(boolean friendly) {
        isFriendly = friendly;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return isFriendly == dog.isFriendly;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + this.getName() + '\'' +
                ", age=" + this.getAge() +
                ", weight=" + this.getWeight() +
                ", speed=" + this.getSpeed() +
                ", isFriendly=" + isFriendly +
                '}';
    }
}
