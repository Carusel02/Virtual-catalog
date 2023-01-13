import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class TeacherPage extends JFrame implements ActionListener {
    JFrame frame;
    JLabel label;
    JTextField textField;
    JButton button;
    String path = "Luminita Costache";
    JButton validate;
    JButton showValidation;
    static ScoreVisitor vizitator;

    int x = 45;

    public TeacherPage() {

        // setare frame
        frame = new JFrame("Teacher/Assistant Page");
        frame.setTitle("ParentPage");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(600, 500);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(252, 237, 218));
        frame.setLocationRelativeTo(null);

        // label insert student
        label = new JLabel("INSERT TEACHER/ASSISTANT:");
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        label.setForeground(new Color(238, 78, 52));
        textField = new JTextField(path);
        button = new JButton("SEARCH");
        button.setForeground(new Color(252, 237, 218));
        button.setBackground(new Color(238, 78, 52));
        button.setFont(new Font("Serif", Font.PLAIN, 20));

        validate = new JButton("VALIDATE");
        validate.setForeground(new Color(25, 25, 112));
        validate.setBackground(new Color(135, 206, 250));
        validate.setFont(new Font("Serif", Font.PLAIN, 20));
        validate.setVisible(false);

        showValidation = new JButton("SHOW GRADES");
        showValidation.setForeground(new Color(25, 25, 112));
        showValidation.setBackground(new Color(135, 206, 250));
        showValidation.setFont(new Font("Serif", Font.PLAIN, 20));
        showValidation.setVisible(false);


        frame.add(label);
        frame.add(textField);
        frame.add(button);
        frame.add(validate);
        frame.add(showValidation);


        label.setBounds(x + 100, 20, 500, 50);
        textField.setBounds(x, 80, 500, 40);
        button.setBounds(x, 150, 500, 40);
        validate.setBounds(x, 260, 500, 40);
        showValidation.setBounds(x,320,500,40);

        button.addActionListener(this);
        validate.addActionListener(this);
        showValidation.addActionListener(this);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Teacher teacher1 = new Teacher("Luminita", "Costache");
        Teacher teacher2 = new Teacher("Carmen", "Odubasteanu");

        Student student1 = new Student("Diana", "Stefan");
        Student student2 = new Student("Valentina", "Baluta");
        Student student3 = new Student("Mihai", "Ghita");
        Student student4 = new Student("Maria", "Costea");
        ArrayList<Student> students1 = new ArrayList<>();
        students1.add(student1);
        students1.add(student2);
        students1.add(student3);
        ArrayList<Student> students2 = new ArrayList<>();
        students2.add(student3);
        students2.add(student4);

        Assistant assistant1 = new Assistant("Mihai", "Eminescu");
        Assistant assistant2 = new Assistant("George", "Enescu");
        Assistant assistant3 = new Assistant("Veronica", "Micle");

        String numeCurs1 = "Matematici speciale";
        String numeCurs2 = "Programare";

        Group grupa1 = new Group("312CC", assistant1);
        grupa1.setStudents(students1);
        Group grupa2 = new Group("323CC", assistant2);
        grupa2.setStudents(students2);

        Grade grade = new Grade();
        grade.setExamScore(2.0);
        grade.setPartialScore(3.0);
        grade.setStudent(student3);

        Grade grade2 = new Grade();
        grade2.setExamScore(2.5);
        grade2.setPartialScore(3.5);
        grade2.setStudent(student1);

        Grade grade3 = new Grade();
        grade3.setExamScore(5.0);
        grade3.setPartialScore(5.0);
        grade3.setStudent(student3);




        Course curs1 = new PartialCourse.PartialCourseBuilder(numeCurs1)
                .teacher(teacher1)
                .assistants(new HashSet<>())
                .grade(new ArrayList<>())
                .dictionary(new HashMap<>())
                .credit(5)
                .build();

        Course curs2 = new PartialCourse.PartialCourseBuilder(numeCurs2)
                .teacher(teacher2)
                .assistants(new HashSet<>())
                .grade(new ArrayList<>())
                .dictionary(new HashMap<>())
                .credit(5)
                .build();

        curs1.addGroup(grupa1);
        curs2.addGroup(grupa2);

        curs1.addAssistant("312CC", assistant2);
        curs2.addAssistant("323CC", assistant1);
        curs2.addAssistant("323CC", assistant2);
        curs2.addAssistant("323CC", assistant3);
        grade.setCourse("Programare");
        grade2.setCourse("Geometrie");
        grade3.setCourse("Analiza");
        curs2.addGrade(grade3);
        curs1.addGrade(grade);
        curs1.addGrade(grade2);
        curs2.addGrade(grade2);


        Parent mother = new Parent("Cori", "Popa");
        Parent father = new Parent("Dorian", "Popa");
        student3.setMother(mother);
        student3.setFather(father);
        Parent mother2 = new Parent("Daniela", "Stefan");
        Parent father2 = new Parent("Vali", "Stefan");
        student1.setMother(mother2);
        student1.setFather(father2);

        Catalog catalog = Catalog.getInstance();
        catalog.addCourse(curs1);
        catalog.addCourse(curs2);

        catalog.notifyObservers(grade);
        catalog.notifyObservers(grade2);
        catalog.notifyObservers(grade3);
        catalog.addObserver(mother);
        catalog.addObserver(mother2);


        ArrayList<Grade> note = new ArrayList<>();
        HashSet<Assistant> assistants = new HashSet<>();

        Student s1 = new Student("Banu","Madalina");
        Student s2 = new Student("Gagu","Elena");
        Student s3 = new Student("Delia","Serbu");
        Student s4 = new Student("Madalina","Voinea");

        Grade nota1 = new Grade();
        nota1.setStudent(s1);
        nota1.setExamScore(5.0);
        nota1.setPartialScore(4.0);
        nota1.setCourse("Mecanica");

        Grade nota2 = new Grade();
        nota2.setStudent(s2);
        nota2.setExamScore(2.0);
        nota2.setPartialScore(3.0);
        nota2.setCourse("Fizica");

        Grade nota3 = new Grade();
        nota3.setStudent(s3);
        nota3.setExamScore(6.0);
        nota3.setPartialScore(7.0);
        nota3.setCourse("Fizica");

        Grade nota4 = new Grade();
        nota4.setStudent(s4);
        nota4.setExamScore(2.0);
        nota4.setPartialScore(1.0);
        nota4.setCourse("Fizica");

        note.add(nota1);
        note.add(nota2);
        note.add(nota3);
        note.add(nota4);

        Assistant AS = new Assistant("Stefanut", "Dragomir");
        assistants.add(AS);

        Course cursTest = new PartialCourse.PartialCourseBuilder("Fizica")
                .teacher(teacher1)
                .assistants(assistants)
                .grade(new ArrayList<>())
                .dictionary(new HashMap<>())
                .credit(5)
                .build();

        Course cursTest2 = new PartialCourse.PartialCourseBuilder("Mecanica")
                .teacher(teacher1)
                .assistants(assistants)
                .grade(new ArrayList<>())
                .dictionary(new HashMap<>())
                .credit(5)
                .build();

        Catalog.getInstance().addCourse(cursTest);
        Catalog.getInstance().addCourse(cursTest2);

        System.out.println(cursTest);

        ScoreVisitor visitor = new ScoreVisitor();
        visitor.createArrayAssistent(note);
        visitor.createArrayTeacher(note);

        vizitator = visitor;
        System.out.println(vizitator.getTeacherArray());


        System.out.println(cursTest);
        System.out.println(cursTest2);


        curs1.makeBackup();
        curs1.addGrade(nota1);
        curs1.addGrade(nota3);
        curs1.addGrade(nota4);

        System.out.println("Curs : " + curs1.getGrade());
        curs1.undo();
        System.out.println("Curs backup : " + curs1.getGrade());





        new TeacherPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == button) {
            int flag = 0;

            path = textField.getText();

            for(Course curs : Catalog.getInstance().cursuri) {
                if(curs.getTeacher().toString().equals(path))
                    flag++;
                for(Assistant asistent : curs.getAssistants()) {
                    if(asistent.toString().equals(path))
                        flag++;
                }

            }

            if(flag != 0) {
                validate.setVisible(true);
                showValidation.setVisible(true);
            } else {
                validate.setVisible(false);
                showValidation.setVisible(false);
            }


        }

        if(e.getSource() == validate) {
            path = textField.getText();

            String[] createUser = path.split(" ");
            String nume = createUser[0];
            String prenume = createUser[1];

            Teacher teacher = new Teacher(nume,prenume);
            Assistant assistant = new Assistant(nume, prenume);

            teacher.accept(vizitator);
            assistant.accept(vizitator);

        }

        if(e.getSource() == showValidation) {
            path = textField.getText();
            new TeacherPageInfo(path);
        }

    }


}
