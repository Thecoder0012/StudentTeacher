import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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

    public Student makeStudent(Scanner scanner, ArrayList<Student> student, FileHandler fileHandler) throws IOException {
        scanner.nextLine();
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter lastName: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter age: ");
        int age = scanner.nextInt();
        System.out.println("Enter height in cm: ");
        double height = scanner.nextDouble();
        System.out.println("Enter true for female and false for male: ");
        boolean gender = scanner.nextBoolean();
        scanner.nextLine();
        System.out.println("Enter country name: ");
        String address = scanner.nextLine();

        Student stu = new Student(name, lastName, age, height, gender, address);
        student.add(stu);
        fileHandler.saveToFile(name,lastName,age,height,gender,address);
        return stu;

    }

    public void changeStudent(Scanner scan, ArrayList<Student> students, FileHandler fileHandler) throws IOException {
        System.out.println(students);
        System.out.println("\nWhich student do you want to change? \nType in an index: ");
        int answer = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter a new name: ");
        String newName = scan.nextLine();
        students.get(answer).setFirstName(newName);
        System.out.println("Enter a new country: ");
        String country = scan.nextLine();
        students.get(answer).setAddress(country);
        System.out.println(students);
        fileHandler.updateFile(students);

    }

    public void printStudents(ArrayList<Student> students){
        System.out.println(students);
    }

    public void sortStudents(ArrayList<Student> students){
        students.sort((o1, o2) -> {
            if (o1.getAge() > o2.getAge())
                return 1;
            else
                return -1;
        });
        printStudents(students);
    }

    public void delete(ArrayList<Student> students, Scanner scanner, FileHandler fileHandler) throws FileNotFoundException {
        printStudents(students);
        System.out.println("\nType in an index to delete a student: ");
        int index = scanner.nextInt();
        students.remove(index);
        printStudents(students);
        fileHandler.updateFile(students);
    }


    public void studentOptions(){
        System.out.println("\n\nEnter:\n***************************************************\n\t" +
                "1 - to show the student lists\n\t"         +
                "2 - to create a new student \n\t"          +
                "3 - to change the student\n\t"             +
                "4 - to view sorted ages of students\n\t"   +
                "5 - to delete a student \n\t"              +
                "6 - quit the program"                      +
                "\n***************************************************\n\nEnter your choice:");
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
                     "\n" +firstName + " \\\\ " +
                          lastName + " \\\\ " +
                          age + " \\\\ " +
                          height + " \\\\ " +
                          gend + " \\\\ " +
                          country + " \\\\ ";
    }
}

