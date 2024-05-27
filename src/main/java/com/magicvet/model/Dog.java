package main.java.com.magicvet.model;

import java.util.Objects;

public class Dog extends Pet {

    private Size size;

    public Dog() { }

    public Dog(Size size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Dog {"
                + "\n\tType = " + getType()
                + ", Sex = " + getSex()
                + ", Age = " + getAge()
                + ", Name = " + getName()
                + ", Size = " + getSize()
                + "\n}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return Objects.equals(size, dog.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size);
    }



    public Size getSize() {
        return size;
    }
    public void setSize(Size size) {
        this.size = size;
    }


    public enum Size {

        XS(1),
        S(2),
        M(3),
        L(4),
        XL(5),
        UNKNOWN(0);

        private final int value;

        Size(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }



}
