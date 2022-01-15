import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);

        ArrayList<Student> student = new ArrayList<>();
        ArrayList<Teacher> teacher = new ArrayList<>();
        // Student studentOb = new Student();

        populateArrayList(student);
        int answer = 7;
        while (answer != 6) {
            System.out.println("\n\nEnter:\n1 to show the student lists\n2 to create a new student \n" +
                    "3 to change the address of the new student's address \n4 to show the teachers\n" +
                    "5 to create a new teacher");
            answer = input.nextInt();

            switch (answer) {
                case 1:
                    System.out.println(student);
                    break;
                case 2:
                    input.nextLine();
                    makeStudent(input, student);
                    toFile(student);
                    break;
                case 3:
                    System.out.println("Do you want to change the address? ");
                    input.nextLine();
                    String ans = input.nextLine();
                    if (ans.equals("Yes") || ans.equals("yes")) {

                        changeAddress(input, student);
                        toFile(student);
                        System.out.println(student);
                    } else if (ans.equals("No") || ans.equals("no")) {
                        System.out.println(student);
                    }
                    break;
                case 4:
                    printTeach(teacher);
                    break;
                case 5:
                    input.nextLine();
                    makeTeacher(input, teacher);
                    break;
                default:
                    System.out.println("Bye bye");
                    break;
            }
        }
    }


    public static Student makeStudent(Scanner scan, ArrayList<Student> student) {
        System.out.println("Enter your new object:\n ");

        System.out.println("Enter name: ");
        String name = scan.nextLine();
        System.out.println("Enter lastName: ");
        String lastName = scan.nextLine();
        System.out.println("Enter age: ");
        String age = scan.nextLine();
        System.out.println("Enter height: ");
        String height = scan.nextLine();
        System.out.println("Enter true for female and false for male: ");
        boolean gender = scan.nextBoolean();
        scan.nextLine();
        System.out.println("Enter address: ");
        String address = scan.nextLine();

        String.valueOf(student);
        Student stu = new Student(name, lastName, age, height, gender, address);
        student.add(stu);
        System.out.println(stu);
        return stu;
    }

    public static void populateArrayList(ArrayList<Student> student) throws IOException {
        File br = new File("student.txt");
        Scanner scanner = new Scanner(br);
        String content = new String(Files.readAllBytes(Paths.get("student.txt"))).trim();

        while (scanner.hasNextLine()) {
            String[] arr = content.split(" // ");
            Student student1 = new Student(arr[0], arr[1], arr[2], arr[3], (arr[4].equals("true")), arr[5]);
            student.add(student1);
            System.out.println(scanner.nextLine());
        }
    }

    public static void toFile(ArrayList<Student> student) throws FileNotFoundException {
        String output = "";
        File f = new File("student.txt");
        PrintStream fileWriter = new PrintStream(f);
        for (int i = 0; i < student.size() - 1; i++) {
            output = student.get(i).getFirstName() + " // " + student.get(i).getLastName()
                    + " // " + student.get(i).getAge()
                    + " // " + student.get(i).getHeight() + " // " +
                    student.get(i).getGender() + " // " + student.get(i).getAddress() + "\n";
            fileWriter.print(output); // printsToFile
        }
    }


    public static void changeAddress(Scanner scan, ArrayList<Student> student) {

        System.out.println("Which student do you want to change?");
        int answer = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter a new name: ");
        String newName = scan.nextLine();
        student.get(answer).setFirstName(newName);
        System.out.println("Enter a new address: ");
        String newAddress = scan.nextLine();
        student.get(answer).setAddress(newAddress);
    }

    private static Teacher makeTeacher(Scanner scan, ArrayList<Teacher> teacher) {
        System.out.println("Enter your new Teacher object:\n ");

        System.out.println("Enter name: ");
        String name = scan.nextLine();
        System.out.println("Enter age: ");
        int age = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter ID: ");
        String id = scan.nextLine();
        System.out.println("Enter the classes he/she teaches");
        String classes = scan.nextLine();

        Teacher teach = new Teacher(name, age, id);
        String[] part = classes.split(",");
        for (int i = 0; i < part.length; i++) {
            teach.addFag(part[i]);
        }
        System.out.println(teach);
        System.out.println();
        return teach;
    }


    public static void printTeach(ArrayList<Teacher> teacher) {
        System.out.println(teacher);
    }

}

