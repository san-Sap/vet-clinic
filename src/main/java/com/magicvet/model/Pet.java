package main.java.com.magicvet.model;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Pet {

    private static final String AGE_PATTERN = "\\d+";

    @Override
    public String toString() {
        return "Pet {"
                + "\n\tType = " + type
                + ", Sex = " + sex
                + ", Age = " + age
                + ", Name = " + name
                + "\n}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(type, pet.type)
                && Objects.equals(sex, pet.sex)
                && Objects.equals(age, pet.age)
                && Objects.equals(name, pet.name)
                && Objects.equals(ownerName, pet.ownerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, sex, age, name, ownerName);
    }

    private String type;
    private String sex;
    private String age;
    private String name;
    private String ownerName;
    private HealthStatus healthStatus;

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        if (age.matches("\\d+")) {
            this.age = age;
        } else {
            System.out.println("Pets age is invalid.");
        }
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }


    public HealthStatus getHealthStatus() {
        return healthStatus;
    }
    public void setHealthStatus(HealthStatus healthStatus) {
        this.healthStatus = healthStatus;
    }


    public enum HealthStatus {

        BAD(1),
        NotVeryGood(2),
        GOOD(3),
        UNKNOWN(0);

        private final int value;

        HealthStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }





}
