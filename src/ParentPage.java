import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ParentPage extends JFrame implements ActionListener {
    JFrame frame;
    JLabel label;
    JTextField textField;
    JButton button;
    JButton buttonNotif;
    ArrayList<JButton> buttons;
    ArrayList<Observer> observatorButon;
    JTextArea textArea;
    String text = "";
    String path = "Cori Popa";

    int y = 200;

    public ParentPage() {
        // setare frame
        frame = new JFrame("ParentPage");
        frame.setTitle("ParentPage");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(500, 300);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(252, 237, 218));
        frame.setLocationRelativeTo(null);

        // label insert student
        label = new JLabel("INSERT PARENT:");
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        label.setForeground(new Color(238, 78, 52));
        textField = new JTextField(path);
        button = new JButton("SEARCH");
        button.setForeground(new Color(252, 237, 218));
        button.setBackground(new Color(238, 78, 52));
        button.setFont(new Font("Serif", Font.PLAIN, 20));
        textArea = new JTextArea();
        textArea.setEditable(false);

        buttonNotif = new JButton("DETALII NOTIFICARE");
        buttonNotif.setForeground(new Color(252, 237, 218));
        buttonNotif.setBackground(new Color(238, 78, 52));
        buttonNotif.setFont(new Font("Serif", Font.PLAIN, 20));
        buttonNotif.setVisible(false);

        frame.add(label);
        frame.add(textField);
        frame.add(button);
        frame.add(buttonNotif);

        label.setBounds(160, 0, 460, 50);
        textField.setBounds(10, 50, 460, 40);
        button.setBounds(10, 100, 460, 50);
        buttonNotif.setBounds(10,180,460,40);
        textArea.setBounds(10, 0, 460, 150);


        button.addActionListener(this);
        buttonNotif.addActionListener(this);
    }

    public static void main(String[] args) {
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

        new ParentPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == button) {
            int flag = 0;

            if(buttons != null)
                for(JButton butonas : buttons) {
                    butonas.setVisible(false);
                }

            path = textField.getText();
            buttons = new ArrayList<>();
            Catalog catalog = Catalog.getInstance();
            ArrayList<Observer> observatori = catalog.getObservers();
            observatorButon = new ArrayList<>();

            for (Observer observator : observatori) {
                    if (observator.toString().equals(path)) {
                        flag = 1;
                        observatorButon.add(observator);
                    }


            }

            // buttonNotif.setVisible(flag == 1);


            for (Observer observator : observatorButon) {
                JButton buton = new JButton("DETALII NOTIFICARI");
                buton.addActionListener(this);
                buton.setFont(new Font("Serif", Font.PLAIN, 20));
                buton.setForeground(new Color(25, 25, 112));
                buton.setBackground(new Color(135, 206, 250));
                frame.add(buton);
                buton.setBounds(10, y - 10, 460, 50);
                buttons.add(buton);
            }


            textArea.setText(String.valueOf(text));
            System.out.println("Array size : " + buttons.size());

        }

        System.out.println("Array size : " + buttons.size());
        for(int i = 0 ; i < buttons.size() ; i++) {
            if (e.getSource() == buttons.get(i)) {
                System.out.println(i);
                new NotificationPageInfo(observatorButon.get(i), path);

            }

            System.out.println(buttons);
        }

        if (e.getSource() == buttonNotif) {
//            new NotificationPageInfo(path);
            System.out.println("TEST");
        }


    }


}
