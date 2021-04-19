package homework.inheritance.animals;

import org.apache.log4j.Logger;

public class ZooDemo {
    private static final Logger logger = Logger.getLogger(ZooDemo.class);

    public static void main(String[] args) {

        Dog dog = new Dog("bobik", 5, 3, 10, true);
        logger.info(dog.voice());
        logger.info(dog.eat());
        logger.info(dog.play());
        logger.info(dog.move());
        dog.setFriendly(false);
        logger.info(dog.play());
        logger.info(dog.toString());
        logger.info("______________________");
        Cat cat = new Cat("barsik",3,2,12,true);
        logger.info(cat.voice());
        logger.info(cat.eat());
        logger.info(cat.play());
        logger.info(cat.move());
        cat.setSharpClaws(false);
        logger.info(cat.play());
        logger.info(cat.toString());
        logger.info("______________________");
        Parrot parrot = new Parrot("Kesha",1,1,20,true);

        logger.info(parrot.voice());
        parrot.setSpeaking(false);
        logger.info(parrot.voice());
        logger.info(parrot.eat());
        logger.info(parrot.move());
        logger.info(parrot.toString());


    }
}
