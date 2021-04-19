package homework.inheritance.animals;

public abstract class Bird extends Animal {
    private boolean isFlying;
    private int speed;

    public Bird(String name, int age, int weight, boolean isFlying, int speed) {
        super(name, age, weight);
        this.isFlying = isFlying;
        this.speed = speed;
    }

    public Bird() {
        super();
    }

    @Override
    public String move() {
        if (this.isFlying()) {
            return this.getName() + " is flying with speed of "+this.getSpeed();
        } else return this.getName() + " is running with speed of "+this.getSpeed();
    }

    @Override
    public String eat() {
        return super.eat() + " worms";
    }

    public boolean isFlying() {
        return isFlying;
    }

    public void setFlying(boolean flying) {
        isFlying = flying;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
