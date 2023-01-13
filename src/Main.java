import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        String name = "Proiectare Logica";
        Teacher teacher = new Teacher("Anca", "Draguta");
        Teacher teacher2 = new Teacher("Proful", "Inlocuitor");


        Assistant assistant1 = new Assistant("Diana", "Stefan");
        Assistant assistant2 = new Assistant("Marius", "Marin");
        ArrayList<Grade> grades = new ArrayList<>();
        Student student = new Student("Valentina", "Baluta");
        Student student2 = new Student("Mary", "Costea");
        Student student3 = new Student("Diana", "Gi");
        Grade grade1 = new Grade();
        grade1.setCourse("Proiectare Logica");
        grade1.setStudent(student);
        grade1.setPartialScore(2.0);
        grade1.setExamScore(3.0);
        grades.add(grade1);
        Grade grade2 = new Grade();
        grade2.setCourse("Algebra");
        grade2.setStudent(student2);
        grade2.setPartialScore(3.0);
        grade2.setExamScore(2.0);
        grades.add(grade2);
        Grade grade3 = new Grade();
        grade3.setCourse("Algebra");
        grade3.setStudent(student2);
        grade3.setPartialScore(3.5);
        grade3.setExamScore(2.5);
        grades.add(grade3);



        HashMap<String, Group> dictionary = new HashMap<>();
        HashSet<Assistant> assistants = new HashSet<>();
        Group grupa = new Group("1", assistant1);



        Course course = new PartialCourse.PartialCourseBuilder(name)
                .teacher(teacher)
                .grade(grades)
                .dictionary(dictionary)
                .assistants(assistants)
                .build();

        course.addGroup("1", assistant1);

        // set and get teacher
        course.setTeacher(teacher2);
        Teacher teacher3 = course.getTeacher();
        // System.out.println("teacher taken : " + teacher3);

        course.setName("Algebra");
        String nameFinal = course.getName();
        // System.out.println("name taken : " + nameFinal);

        course.addAssistant("1", assistant2);

        System.out.println(course);
    }
}