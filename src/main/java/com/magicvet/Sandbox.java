package main.java.com.magicvet;

//import main.java.com.magicvet.comparator.DogSizeComparator;
import main.java.com.magicvet.comparator.HealthStatusComparator;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

import java.util.Arrays;
import java.util.Comparator;

public class Sandbox {

    public static void main(String[] args) {

        Dog[] dogs = {
                new Dog(Dog.Size.M, Dog.HealthStatus.BAD),
                new Dog(Dog.Size.S, Dog.HealthStatus.BAD),
                new Dog(Dog.Size.XL, Dog.HealthStatus.GOOD),
                new Dog(Dog.Size.XL, Dog.HealthStatus.BAD),
                new Dog(Dog.Size.XS, Dog.HealthStatus.GOOD),
                new Dog(Dog.Size.S, Dog.HealthStatus.GOOD)
        };

        Arrays.sort(dogs, new Comparator<Dog>() {
            @Override
            public int compare (Dog o1, Dog o2) {
                return o1.getSize().getValue() - o2.getSize().getValue();
            }
        });

        for (Dog dog : dogs) {
            System.out.println(dog.getSize() + "  " + dog.getHealthStatus());
            }
        System.out.println();
        System.out.println();

        Arrays.sort(dogs, new HealthStatusComparator() {

        });

        for (Dog dog : dogs) {
            System.out.println(dog.getSize() + "  " + dog.getHealthStatus());
        }





        System.out.println();
    }
}
