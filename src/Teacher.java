import java.util.*;

public class Teacher {

    private String name;
    private int age;
    private String id;

    ArrayList<String> fagList = new ArrayList<>();

    Teacher(String name, int age, String id) {

        this.name = name;
        this.age = age;
        this.id = id;
    }




    @Override
    public String toString() {
        return "\nTeacher: {" +
                "\nname = " + name + "\n" +
                "age= " + age + "\n" +
                "id= " + id + "\n" + fagList +
                '}';
    }



    public void addFag(String fag){
        fagList.add(fag);
    }


}
