import java.util.*;

public class Student{

    private String firstName;
    private String lastName;
    private String age;
    private String height;
    private boolean gender;
    private String address;


    Student(String firstName, String lastName, String age, String height, boolean gender, String address) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
        this.gender = gender;
        this.address = address;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

  /* public String toString(){
        String gend = gender? "female": "male";
        return ("First name: "+ firstName+"\nLast name: "+lastName+"\nAddress: "+address+"\nAge: "+ age+"\nHeight: "+height+"\nGender: "+gend+"\n");
    }*/


    @Override
    public String toString() {
        String gend = gender ? "female" : "male";
        return
                    getClass().getSimpleName()+ ":\n" +firstName + "\n" +
                          lastName + "\n" +
                          age + "\n" +
                          height + "\n" +
                          gend + "\n" +
                          address + "\n";
    }
}


/*
* public String toString() {
        String gend = gender? "female": "male";
        return
                "\n***************\n"+
                        getClass().getSimpleName()+":"+
                "\nfirstName = " + firstName + "\n" +
                "lastName = " + lastName + "\n" +
                "age = " + age + "\n" +
                "height = " + height + "\n" +
                "gender = " + gend + "\n" +
                "address = " + address +  "\n"+
                "***************";
    }
*
* */
