import java.util.*;

public class Student{

    private String firstName;
    private String lastName;
    private int age;
    private double height;
    private boolean gender;
    private String country;


    Student(String firstName, String lastName, int age, double height, boolean gender, String country) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
        this.gender = gender;
        this.country = country;
    }

    public Student() {
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return country;
    }

    public void setAddress(String address) {
        this.country = address;
    }


    @Override
    public String toString() {
        String gend = getGender() ? "female" : "male";
        return
                    getClass().getSimpleName()+ ":\n" +firstName + "\n" +
                          lastName + "\n" +
                          age + "\n" +
                          height + "\n" +
                          gend + "\n" +
                          country + "\n";
    }
}

