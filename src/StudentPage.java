import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class StudentPage extends JFrame implements ActionListener {
    JFrame frame;
    JLabel label;
    JTextField textField;
    JButton button;
    ArrayList<JButton> buttons;

    ArrayList<Course> cursButon;
    JTextArea textArea;
    String text = "";
    String path = "Mihai Ghita";
    int y;

    public StudentPage() {
        // setare frame
        frame = new JFrame("StudentPage");
        frame.setTitle("StudentPage");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(500, 700);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(252, 237, 218));
        frame.setLocationRelativeTo(null);

        // label insert student
        label = new JLabel("INSERT STUDENT:");
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        label.setForeground(new Color(238, 78, 52));
        textField = new JTextField(path);
        button = new JButton("SEARCH");
        button.setForeground(new Color(252, 237, 218));
        button.setBackground(new Color(238, 78, 52));
        button.setFont(new Font("Serif", Font.PLAIN, 20));
        textArea = new JTextArea();
        textArea.setEditable(false);

        frame.add(label);
        frame.add(textField);
        frame.add(button);


        label.setBounds(160, 0, 460, 50);
        textField.setBounds(10, 50, 460, 40);
        button.setBounds(10, 100, 460, 50);
        textArea.setBounds(10, 0, 460, 150);


        button.addActionListener(this);
    }

    public static void main(String[] args) {

        Teacher teacher1 = new Teacher("Luminita", "Costache");
        Teacher teacher2 = new Teacher("Carmen", "Odubasteanu");
        Teacher teacher3 = new Teacher("Razvan", "Deaconescu");
        Teacher teacher4 = new Teacher("Florin", "Pop");

        Student student1 = new Student("Diana", "Stefan");
        Student student2 = new Student("Valentina", "Baluta");
        Student student3 = new Student("Mihai", "Ghita");
        Student student4 = new Student("Maria", "Costea");
        Student student5 = new Student("David", "Paduretu");
        Student student6 = new Student("Roberta", "Manolache");
        Student student7 = new Student("Diana", "Gorescu");
        Student student8 = new Student("Ionela", "Naziru");
        Student student9 = new Student("Ioana", "Macreanu");
        Student student10 = new Student("Alin", "Ionut");
        Student student11 = new Student("George", "Paduret");


        // array Studenti
        ArrayList<Student> students1 = new ArrayList<>();
        students1.add(student1);
        students1.add(student2);
        students1.add(student3);
        students1.add(student4);
        students1.add(student5);
        students1.add(student6);
        students1.add(student7);

        ArrayList<Student> students2 = new ArrayList<>();
        students2.add(student8);
        students2.add(student9);
        students2.add(student10);
        students2.add(student11);

        Assistant assistant1 = new Assistant("Mihai", "Eminescu");
        Assistant assistant2 = new Assistant("George", "Enescu");
        Assistant assistant3 = new Assistant("Veronica", "Micle");
        Assistant assistant4 = new Assistant("Ion", "Creanga");

        String numeCurs1 = "Matematici speciale";
        String numeCurs2 = "Programare";
        String numeCurs3 = "USO";
        String numeCurs4 = "IOCLA";

        Group grupa1 = new Group("321CC", assistant1);
        grupa1.setStudents(students1);
        Group grupa2 = new Group("322CC", assistant2);
        grupa2.setStudents(students1);
        Group grupa3 = new Group("323CC", assistant3);
        grupa3.setStudents(students1);
        Group grupa4 = new Group("324CC", assistant4);
        grupa4.setStudents(students2);

        Grade grade1 = new Grade();
        grade1.setExamScore(2.0);
        grade1.setPartialScore(3.0);
        grade1.setStudent(student1);
        grade1.setCourse(numeCurs1);

        Grade grade2 = new Grade();
        grade2.setExamScore(2.5);
        grade2.setPartialScore(3.5);
        grade2.setStudent(student2);

        Grade grade3 = new Grade();
        grade3.setExamScore(3.5);
        grade3.setPartialScore(4.5);
        grade3.setStudent(student3);


        Grade grade4 = new Grade();
        grade4.setExamScore(5.0);
        grade4.setPartialScore(3.2);
        grade4.setStudent(student4);

        Grade grade5 = new Grade();
        grade5.setExamScore(4.4);
        grade5.setPartialScore(2.7);
        grade5.setStudent(student5);

        Grade grade6 = new Grade();
        grade6.setExamScore(3.9);
        grade6.setPartialScore(2.9);
        grade6.setStudent(student6);

        Grade grade7 = new Grade();
        grade7.setExamScore(3.6);
        grade7.setPartialScore(3.7);
        grade7.setStudent(student7);

        Grade grade8 = new Grade();
        grade8.setExamScore(4.4);
        grade8.setPartialScore(4.4);
        grade8.setStudent(student8);

        Grade grade9 = new Grade();
        grade9.setExamScore(5.0);
        grade9.setPartialScore(1.3);
        grade9.setStudent(student9);

        Grade grade10 = new Grade();
        grade10.setExamScore(0.9);
        grade10.setPartialScore(5.0);
        grade10.setStudent(student10);

        Grade grade11 = new Grade();
        grade11.setExamScore(2.7);
        grade11.setPartialScore(3.0);
        grade11.setStudent(student11);



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

        Course curs3 = new PartialCourse.PartialCourseBuilder(numeCurs3)
                .teacher(teacher3)
                .assistants(new HashSet<>())
                .grade(new ArrayList<>())
                .dictionary(new HashMap<>())
                .credit(5)
                .build();

        Course curs4 = new FullCourse.FullCourseBuilder(numeCurs4)
                .teacher(teacher4)
                .assistants(new HashSet<>())
                .grade(new ArrayList<>())
                .dictionary(new HashMap<>())
                .credit(5)
                .build();

        curs1.addGroup(grupa1);
        curs2.addGroup(grupa2);
        curs3.addGroup(grupa3);
        curs4.addGroup(grupa4);

        curs1.addAssistant("321CC", assistant2);
        curs2.addAssistant("322CC", assistant1);
        curs3.addAssistant("323CC", assistant1);
        curs4.addAssistant("324CC", assistant1);

        ArrayList<Grade> grades = new ArrayList<>();
        grades.add(grade1);
        grades.add(grade2);
        grades.add(grade3);
        grades.add(grade4);
        grades.add(grade5);
        grades.add(grade6);
        grades.add(grade7);
        grades.add(grade8);
        grades.add(grade9);
        grades.add(grade10);
        grades.add(grade11);
        curs1.setGrade(grades);
        curs2.setGrade(grades);
        curs3.setGrade(grades);
        curs4.setGrade(grades);

        Parent mother1 = new Parent("Daniela", "Stefan");
        Parent father1 = new Parent("Vali", "Stefan");
        student1.setMother(mother1);
        student1.setFather(father1);

        Parent mother2 = new Parent("Adriana", "Baluta");
        Parent father2 = new Parent("Iulian", "Baluta");
        student2.setMother(mother2);
        student2.setFather(father2);


        Catalog catalog = Catalog.getInstance();
        catalog.addCourse(curs1);
        catalog.addCourse(curs2);
        catalog.addCourse(curs3);
        catalog.addCourse(curs4);

        catalog.notifyObservers(grade1);
        catalog.addObserver(mother1);
        System.out.println(mother1.notifications);

        // best exam score
        curs1.setS(new BestExamScore());
        System.out.println(curs1.getBestStudent());

        // best partial score
        curs1.setS(new BestPartialScore());
        System.out.println(curs1.getBestStudent());

        // best total score
        curs1.setS(new BestTotalScore());
        System.out.println(curs1.getBestStudent());


        new StudentPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == button) {

            if(buttons != null)
                for(JButton butonas : buttons) {
                    butonas.setVisible(false);
                }

            path = textField.getText();
            buttons = new ArrayList<>();
            Catalog catalog = Catalog.getInstance();
            ArrayList<Course> cursuri = catalog.getCursuri();
            cursButon = new ArrayList<>();

            for (Course curs : cursuri) {
                for (Student x : curs.getAllStudents()) {
                    if (x.toString().equals(path)) {
                        cursButon.add(curs);
                    }
                }

            }

            y = 200;

            for (Course curs : cursButon) {
                JButton buton = new JButton(curs.getName());
                buton.addActionListener(this);
                buton.setForeground(new Color(25, 25, 112));
                buton.setBackground(new Color(135, 206, 250));
                buton.setFont(new Font("Serif", Font.PLAIN, 20));
                frame.add(buton);
                buton.setBounds(10, y, 460, 40);
                y += 60;
                buttons.add(buton);
            }

            textArea.setText(String.valueOf(text));
        }

        for(int i = 0 ; i < buttons.size() ; i++) {
            if (e.getSource() == buttons.get(i)) {
                new CoursePageInfo(cursButon.get(i), path);
            }

        }




    }


}
