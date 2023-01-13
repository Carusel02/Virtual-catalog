import javax.swing.*;
import java.awt.*;
import java.util.HashSet;

public class CoursePageInfo extends JFrame {
    JFrame frame;
    int y = 20;
    int x = 10;
    public CoursePageInfo(Course course, String text) {
        // setare frame
        frame = new JFrame("CoursePageInfo");
        frame.setVisible(true);
        frame.setSize(700, 700);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(252, 237, 218));
        frame.setLocationRelativeTo(null);

        // setare nume curs
        JLabel labelName = new JLabel("Cursul de " + course.getName());
        labelName.setLayout(null);
        labelName.setFont(new Font("Serif", Font.PLAIN, 45));
        labelName.setForeground(new Color(238, 78, 52));
        labelName.setBounds(x,y,600,50);
        y += 80;

        JLabel teacherAdd = new JLabel("Profesor titular");
        teacherAdd.setLayout(null);
        teacherAdd.setFont(new Font("Serif", Font.PLAIN, 30));
        teacherAdd.setForeground(new Color(25, 25, 112));
        teacherAdd.setBounds(x,y,600, 35);
        y += 45;

        String numeProf = course.getTeacher().toString();
        JLabel teacherName = new JLabel(numeProf);
        teacherName.setLayout(null);
        teacherName.setFont(new Font("Serif", Font.PLAIN, 30));
        teacherName.setBounds(x + 20,y,600, 35);
        y += 45;

        JLabel labelAsistenti = new JLabel("Asistenti ");
        labelAsistenti.setLayout(null);
        labelAsistenti.setFont(new Font("Serif", Font.PLAIN, 30));
        labelAsistenti.setForeground(new Color(25, 25, 112));
        labelAsistenti.setBounds(x,y,600,35);
        y += 45;

        HashSet<Assistant> assistantHashSet = course.getAssistants();
        for(Assistant asist : assistantHashSet) {
            JLabel labelAsistents = new JLabel(asist.toString());
            labelAsistents.setLayout(null);
            labelAsistents.setFont(new Font("Serif", Font.PLAIN, 20));
            labelAsistents.setBounds(x + 20,y,600,25);
            y += 35;
            frame.add(labelAsistents);
        }



        JLabel textStud = new JLabel("Student " + text);
        textStud.setLayout(null);
        textStud.setFont(new Font("Serif", Font.PLAIN, 30));
        textStud.setForeground(new Color(25, 25, 112));
        textStud.setBounds(x,y,600,35);
        y += 45;

        String[] creareStud = text.split(" ");
        Student studentul = new Student(creareStud[0], creareStud[1]);
        Grade nota = course.getGrade(studentul);

        JLabel notare = new JLabel("Notare");
        notare.setLayout(null);
        notare.setFont(new Font("Serif", Font.PLAIN, 20));
        notare.setBounds(x + 20, y,500,25);
        y += 30;

        // partial score
        JLabel partialScore;
        if(nota.getPartialScore() == null)
            partialScore = new JLabel("not completed partial score");
        else
            partialScore = new JLabel("partial score " + nota.getPartialScore());
        partialScore.setLayout(null);
        partialScore.setFont(new Font("Serif", Font.BOLD, 20));
        partialScore.setForeground(Color.BLACK);
        partialScore.setBounds(x + 20, y,500,25);
        y += 30;

        // exam score
        JLabel examScore;
        if(nota.getExamScore() == null)
            examScore = new JLabel("not completed exam score");
        else
            examScore = new JLabel("exam score " + nota.getExamScore());
        examScore.setLayout(null);
        examScore.setFont(new Font("Serif", Font.BOLD, 20));
        examScore.setForeground(Color.BLACK);
        examScore.setBounds(x + 20, y,500,25);
        y += 30;


        frame.add(labelName);
        frame.add(teacherAdd);
        frame.add(teacherName);
        frame.add(labelAsistenti);
        frame.add(textStud);
        frame.add(notare);
        frame.add(partialScore);
        frame.add(examScore);

    }

}
