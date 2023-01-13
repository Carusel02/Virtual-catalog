import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener {
    JFrame frame;

    JButton b1;

    JButton b2;

    JButton b3;

    public MainMenu() {
        // setare frame
        frame = new JFrame("MainMenu");
        frame.setVisible(true);
        frame.setSize(1000, 1000);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(252, 237, 218));
        frame.setLocationRelativeTo(null);

        b1 = new JButton("STUDENT");
        b1.setForeground(new Color(252, 237, 218));
        b1.setBackground(new Color(238, 78, 52));
        b1.setFont(new Font("Serif", Font.PLAIN, 20));

        b2 = new JButton("PARENT");
        b2.setForeground(new Color(252, 237, 218));
        b2.setBackground(new Color(238, 78, 52));
        b2.setFont(new Font("Serif", Font.PLAIN, 20));

        b3 = new JButton("TEACHER");
        b3.setForeground(new Color(252, 237, 218));
        b3.setBackground(new Color(238, 78, 52));
        b3.setFont(new Font("Serif", Font.PLAIN, 20));

        frame.add(b1);
        frame.add(b2);
        frame.add(b3);

        b1.setBounds(10, 100, 460, 40);
        b2.setBounds(10, 150, 460, 40);
        b3.setBounds(10, 200, 460, 40);


    }

    public static void main(String[] args) {
        new MainMenu();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1) {
            new StudentPage();
        }

        if(e.getSource() == b2) {
            new ParentPage();
        }

        if(e.getSource() == b3) {
            new TeacherPage();
        }


    }
}





