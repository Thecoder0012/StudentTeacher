import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {


    public void saveToFile(String name, String lastName, int age, double height, boolean gender, String address) throws IOException {
           FileWriter fileWriter = new FileWriter("student.txt", true);
           fileWriter.append(name + " // " + lastName + " // " + age + " // " + height + " // " + gender + " // " + address);
           fileWriter.close();
    }
    public static void updateFile(ArrayList<Student> student) throws FileNotFoundException {
        String output = "";
        File file = new File("student.txt");
        PrintStream printStream = new PrintStream(file);
        for (int i = 0; i < student.size(); i++) {
            output += student.get(i).getFirstName() + " // " + student.get(i).getLastName()
                    + " // " + student.get(i).getAge()
                    + " // " + student.get(i).getHeight() + " // " +
                    student.get(i).getGender() + " // " + student.get(i).getAddress() + "\n";
        }
        printStream.append(output);
        printStream.close();
    }

    public static void populateArrayList(ArrayList<Student> student) throws IOException {
        File br = new File("student.txt");
        Scanner scanner = new Scanner(br);
        while (scanner.hasNext()) {
            String[] arr = scanner.nextLine().split(" // ");
            Student student1 = new Student(arr[0], arr[1], (Integer.parseInt(arr[2])), (Double.parseDouble(arr[3])), (Boolean.parseBoolean(arr[4])), arr[5]);
            student.add(student1);
        }
    }
}