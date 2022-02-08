import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    final Scanner input = new Scanner(System.in);
    final FileHandler fileHandler = new FileHandler();
    final Student studentObject = new Student();
    final ArrayList<Student> studentsList = new ArrayList<>();

    public void run() throws IOException {
        FileHandler.populateArrayList(studentsList);
        boolean runProgram = true;
        while (runProgram) {
           studentObject.studentOptions();

            int  answer = input.nextInt();
            switch (answer) {

                case 1 -> studentObject.printStudents(studentsList);

                case 2 -> studentObject.makeStudent(input, studentsList, fileHandler);

                case 3 -> studentObject.changeStudent(input, studentsList, fileHandler);

                case 4 -> studentObject.sortStudents(studentsList);

                case 5 -> studentObject.delete(studentsList, input, fileHandler);

                case 6 -> runProgram = false;

                default -> {

                    if (runProgram) {
                            System.out.println("Type in a valid number");
                    }
                }
            }
        }
    }
}
