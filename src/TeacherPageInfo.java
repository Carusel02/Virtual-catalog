import javax.swing.*;
import java.awt.*;
public class TeacherPageInfo extends JFrame {
    JFrame frame;



    int y = 20;

    int x = 10;
    public TeacherPageInfo(String path) {
        // setare frame
        frame = new JFrame("TeacherPageInfo");
        frame.setVisible(true);
        frame.setSize(1000, 1000);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(252, 237, 218));
        frame.setLocationRelativeTo(null);

        int findAsistent = 0;

        for(Course curs : Catalog.getInstance().cursuri) {
            for(Assistant asistent  : curs.getAssistants()) {
                if(asistent.toString().equals(path))
                    findAsistent = 1;
            }
        }

        for(Course curs : Catalog.getInstance().cursuri) {
            if(curs.getTeacher().toString().equals(path) || findAsistent == 1) {
                JLabel label = new JLabel(curs.getName());
                label.setForeground(new Color(238, 78, 52));
                label.setLayout(null);
                label.setFont(new Font("Serif", Font.PLAIN, 35));
                frame.add(label);
                label.setBounds(x,y,460,40);
                y += 45;
                for(Grade g : curs.getGrade()) {
                    JLabel nume = new JLabel("Student " + g.getStudent().toString());
                    nume.setLayout(null);
                    nume.setFont(new Font("Serif", Font.PLAIN, 20));
                    nume.setForeground(new Color(25, 25, 112));
                    frame.add(nume);
                    nume.setBounds(x,y,460,25);
                    y += 25;
                    JLabel examScore;
                    if(g.getExamScore() != null) {
                        examScore = new JLabel("Exam score  " + g.getExamScore().toString());
                        examScore.setForeground(Color.black);
                        examScore.setFont(new Font("Serif", Font.BOLD, 16));
                    }
                    else {
                        examScore = new JLabel("exam score not completed");
                        examScore.setForeground(Color.red);
                        examScore.setFont(new Font("Serif", Font.ITALIC, 16));
                    }
                    examScore.setLayout(null);
                    frame.add(examScore);
                    examScore.setBounds(x,y,460,20);
                    y += 20;
                    JLabel partialScore;
                    if(g.getPartialScore() != null) {
                        partialScore = new JLabel("Partial score  " + g.getPartialScore().toString());
                        partialScore.setForeground(Color.black);
                        partialScore.setFont(new Font("Serif", Font.BOLD, 16));
                    }
                    else {
                        partialScore = new JLabel("partial score not completed");
                        partialScore.setForeground(Color.red);
                        partialScore.setFont(new Font("Serif", Font.ITALIC, 16));
                    }

                    partialScore.setLayout(null);
                    frame.add(partialScore);
                    partialScore.setBounds(x,y,460,20);
                    y += 20;

                }

                y += 10;

                if( y > 800 ) {
                    x += 350;
                    y = 20;
                }
            }
        }


    }

}


