import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.random.RandomGenerator;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Test {
    public static void main(String[] args) {

        Teacher teacher1 = new Teacher("Luminita", "Costache");
        Teacher teacher2 = new Teacher("Carmen", "Odubasteanu");
        Teacher teacher3 = new Teacher("Razvan", "Deaconescu");
        Teacher teacher4 = new Teacher("Mircea", "Olteanu");

        Student student1 = new Student("Diana", "Stefan");
        Student student2 = new Student("Valentina", "Baluta");
        Student student3 = new Student("Mihai", "Ghita");
        Student student4 = new Student("Maria", "Costea");

        Assistant assistant1 = new Assistant("Mihai", "Eminescu");
        Assistant assistant2 = new Assistant("George", "Enescu");
        Assistant assistant3 = new Assistant("Ion", "Creanga");
        Assistant assistant4 = new Assistant("Mihail", "Sadoveanu");

        String numeCurs1 = "Matematici speciale";
        String numeCurs2 = "Programare";
        String numeCurs3 = "IOCLA";
        String numeCurs4 = "Analiza";

        Course curs1 = new PartialCourse.PartialCourseBuilder(numeCurs1)
                .teacher(teacher1)
                .assistants(new HashSet<>())
                .grade(new ArrayList<>())
                .dictionary(new HashMap<>())
                .credit(5)
                .build();

        System.out.println(curs1);





    }
}
