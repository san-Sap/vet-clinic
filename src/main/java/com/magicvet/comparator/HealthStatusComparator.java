
package main.java.com.magicvet.comparator;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;
import java.util.Comparator;

public class HealthStatusComparator implements Comparator<Pet> {

    @Override
    public int compare(Pet pet1, Pet pet2) {

        return pet1.getHealthStatus().getValue() - pet2.getHealthStatus().getValue();
        }






}

